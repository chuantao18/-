package struct.link;

import org.junit.Test;

public class CircularLinkTest {
    @Test
    public void test() {
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> thirty = new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> sixth = new Node<>("ff", null);
        Node<String> seventh = new Node<>("gg", null);

        //构成循环链表
        first.next = second;
        second.next = thirty;
        thirty.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = first;
    }

    private class Node<T> {
        T item;
        Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
