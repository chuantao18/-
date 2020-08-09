package struct.queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private Node head;
    private Node last;
    private int N;

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        N = 0;
    }

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enQueue(T t) {
        Node oldNode = head.next;
        if (null == oldNode) {
            last = new Node(t, null);
            head.next = last;
        } else {
            Node newNode = new Node(t, null);
            last.next = newNode;
            last = newNode;
        }
        ++N;
    }

    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        Node oldNode = head.next;
        head.next = oldNode.next;
        oldNode.next = null;
        --N;
        return oldNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator {
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
