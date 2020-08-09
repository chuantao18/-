package struct.symbol;

public class SymbolTable<Key, Value> {

    private Node head;
    private int N;


    public SymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        //键已经存在
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        //键不存在
        Node oldNode = head;
        Node newNode = new Node(key, value, oldNode.next);
        oldNode.next = newNode;
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
