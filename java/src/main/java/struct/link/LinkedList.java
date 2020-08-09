package struct.link;

public class LinkedList {

    public Node head;

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println("遍历完毕，请指示，将军！");
    }

    //    链表头部插入 链表
    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //    数值的方式插入头部
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    //    头部后面插入
    public void insertAfterHead(Node newNode) {
        if (head == null) {
            head = newNode;
            return;
        }

        Node p = head;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertAfterHead(int value) {
        Node newNode = new Node(value, null);
        insertAfterHead(newNode);
    }

    //    尾部插入
    public void insertToTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    //    某一个节点之前插入
    public void insertBefore(Node p, int value) {

        Node newNode = new Node(value, null);

        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        if (p.data == head.data) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q.next != null && q.next.data != p.data) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = q.next;
        q.next = newNode;
    }

    //    某一个节点之后插入
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        if (p.data == head.data) {
            insertAfterHead(newNode);
            return;
        }

        Node q = head;

        while (q.data != p.data) {
            q = q.next;
        }
        if (q.next == null && q.data != p.data) {
            return;
        }

        newNode.next = q.next;
        q.next = newNode;
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

//    删除头节点

    public void deleteHead() {
        if (head == null) {
            return;
        }

        Node p = head;
        head = p.next;
        p = null;
    }

    //删除尾节点
    public void deleteTail() {
        if (head == null) {
            return;
        }

        Node p = head;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
    }
    //删除指定节点

    public void deleteNode(int value) {
        Node oldNode = new Node(value, null);
        deleteNode(oldNode);
    }

    public void deleteNode(Node oldNode) {
        if (head == null) {
            return;
        }

        if (oldNode.data == head.data) {
            deleteHead();
            return;
        }

        Node p = head;
        while (p.next.data != oldNode.data) {
            p = p.next;
        }

        if (p.next.next == null) {
            deleteTail();
            return;
        }

        p.next = p.next.next;
    }

    //查找指定节点
    public int findByNode(Node node) {
        int point = 1;
        if (head == null) {
            return 0;
        }

        Node p = head;
        while (p != null && p.data != node.data) {
            point++;
            p = p.next;
        }

        if (p == null) {
            return -1;
        }
        return point;
    }

    public int findByNode(int value) {
        Node node = new Node(value, null);
        return findByNode(node);
    }

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
//        Node newNode = Node.createNode(1);
//        list.insertToHead(newNode);
        int data[] = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < data.length; i++) {
            list.insertToHead(data[i]);
        }
//        list.insertToTail(7);
//       list.insertBefore(new Node(1, null), 10);
//        list.insertAfterHead(8);
//        list.insertAfter(new Node(6, null), 11);

//        list.deleteHead();
//        list.deleteTail();
//        list.deleteNode(2);
        list.printAll();
//        System.out.println(list.findByNode(9));
 //       System.out.println(list.findByValue(1).data);
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

}
