package struct.link;

public class CircleLinkedList {

    public Node head;
    public Node tail;

    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            head.next = head;
            tail = head;
            return;
        }
        Node p = head;
        while (p != tail) {
            p = p.next;
        }

        newNode.next = p.next;
        p.next = newNode;
        tail = newNode;
    }

    public void deleteNode(int value) {
        Node oldNode = new Node(value, null);
        if (head == null) {
            return;
        }
        Node p = head;

    }

    /*
     * 按照值查询链表
     *  @params value
     */
    public Node findNode(int value) {
        Node current = head;
        do {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    public void printAll() {
        Node p = head;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != head);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return this.data;
        }

        public static Node createNode(int data) {
            return new Node(data, null);
        }

    }

    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        int[] data = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < data.length; i++) {
            circleLinkedList.insertTail(data[i]);
        }
        circleLinkedList.printAll();
        if (circleLinkedList.findNode(7) != null) {
            System.out.println();
        }
        System.out.println("沉痛悼念凉山消防战士！");
    }

}
