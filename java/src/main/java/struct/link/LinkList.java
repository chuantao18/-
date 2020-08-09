package struct.link;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {

    //记录头结点
    private Node head;
    //链表中存储节点的个数
    private int N;

    //节点类
    private class Node {
        T item;
        Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        //初始化头结点
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        this.head.next = null;
        this.N = 0;
    }

    public int length() {
        return this.N;
    }

    public boolean isEmpty() {
        if (this.N == 0)
            return true;
        return false;
    }

    //获取指定位置i出现的元素
    public T get(int i) {
        if (i < 0 || i > N) {
            return null;
        }
        Node node = head.next;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node.item;
    }

    //在链表最后插入新节点
    public void insert(T t) {
        Node node = head;
        while (null != node.next) {
            node = node.next;
        }
        Node newNode = new Node(t, null);
        node.next = newNode;
        ++this.N;
    }

    //指定位置处插入新节点
    public void insert(int i, T t) {
        Node n = head;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        Node newNode = new Node(t, n.next);
        n.next = newNode;
        ++N;
    }

    //删除指定位置的节点，并返回数据
    public T remove(int i) {
        Node pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        //当前节点
        Node curr = pre.next;
        //下一个节点
        Node nextNode = curr.next;
        //删除节点
        pre.next = nextNode;
        --N;
        return curr.item;
    }

    //查找元素t第一次在链表中出现的位置
    public int get(T t) {
        Node node = head;
        for (int j = 0; null != node.next; j++) {
            node = node.next;
            if (node.item.equals(t)) {
                return j;
            }
        }
        return -1;
    }

    //反转整个链表
    public void reverse() {
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    //反转某一个节点
    public Node reverse(Node curr) {
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }
        Node pre = reverse(curr.next);
        pre.next = curr;
        curr.next = null;
        return curr;
    }


    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator {
        Node n;

        public LIterator() {
            n = head;
        }

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

