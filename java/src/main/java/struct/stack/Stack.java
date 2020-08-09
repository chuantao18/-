package struct.stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private Node head;
    private int N;


    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //栈中元素个数
    public int size() {
        return N;
    }

    //压栈操作
    public void push(T t) {
        //先找到首节点指向的第一个节点
        Node oldNode = head.next;
        //创建新节点
        Node newNode = new Node(t, null);
        //头结点指向新节点
        head.next = newNode;
        //新节点指向原来的第一个节点
        newNode.next = oldNode;
        //栈的个数增加
        ++N;
    }

    //出栈or弹栈
    public T pop() {
        Node oldNode = head.next;
        if (oldNode == null) {
            return null;
        }
        head.next = oldNode.next;
        --N;
        return oldNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {

        private Node n = head;

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
