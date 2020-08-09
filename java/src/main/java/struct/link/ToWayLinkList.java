package struct.link;

import java.util.Iterator;

public class ToWayLinkList<T> implements Iterable<T> {

    private Node head;

    private Node last;
    private int N;

    private class Node {
        T item;
        Node pre;
        Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    //初始化双向链表
    public ToWayLinkList() {
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    //清空链表
    public void clear() {
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }

    //链表的长度
    public int length() {
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取第一个链表的值
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    //获取最后一个链表的值
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        //Node n = head;
        //for (int i = 0; i < N; i++) {
        //    n = n.next;
        //}
        return last.item;
    }

    //在链表尾部插入节点
    public void insert(T t) {
        if (isEmpty()) {
            //1.新建节点
            Node newNode = new Node(t, head, null);
            //2.新节点为尾节点  2-3顺序可颠倒，没影响
            last = newNode;
            //3.头结点指向尾节点
            head.next = newNode;

        } else {
            // 1.新建节点
            Node newNode = new Node(t, last, null);
            // 2.尾结点作为新节点的前驱
            last.next = newNode;
            //3.新节点作为尾结点
            last = newNode;
        }
        ++this.N;
    }

    //在链表指定位置插入节点
    public void insert(int i, T t) {
        Node n = head;
        //找到前一个节点
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        Node curr = n.next;
        //新建节点,前驱为前一个节点，后继为当前节点
        Node newNode = new Node(t, n, curr);
        //前一个节点指向下一个节点
        n.next = newNode;
        //当前节点指向新节点
        curr.pre = newNode;
        ++N;
    }

    //获取指定位置的节点的值
    public T get(int i) {
        //Node node = head;
        //for (int j = 0; j < N; j++) {
        //    node = node.next;
        //}
        //Node curr = node.next;
        //return curr.item;

        Node n = head.next;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.item;
    }

    //判断元素值第一次在链表中出现的位置
    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; i < N; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    //删除指定位置的节点
    public T remove(int i) {
        Node node = head;
        //前一个节点
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        //当前节点
        Node curr = node.next;
        //下一个节点
        Node nextNode = curr.next;
        //前一个节点指向当前节点后一个节点
        node.next = nextNode;
        //当前节点后一个节点-->前一个节点
        nextNode.pre = node;
        --N;
        return curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator {
        Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
