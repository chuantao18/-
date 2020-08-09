package struct.symbol;

public class OrderSymbolTable<Key extends Comparable<Key>, Value> {

    private Node head;
    private int N;

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        Node curr = head.next;
        Node pre = head;

        while (curr != null && key.compareTo(curr.key) > 0) {
            pre = curr;
            curr = curr.next;
        }

        //键已经存在
        if (curr != null && key.compareTo(curr.key) == 0) {
            curr.value = value;
        }
        //键不存在
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
        ++N;
    }

    public Value get(Key key) {
        //键已经存在
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        //键已经存在
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                --N;
                return;
            }
            n = n.next;
        }
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
