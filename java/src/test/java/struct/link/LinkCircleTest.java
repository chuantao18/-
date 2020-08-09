package struct.link;

import org.junit.Test;

public class LinkCircleTest {
    @Test
    public void test() {

        //新建节点
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> thirty = new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> sixth = new Node<>("ff", null);
        Node<String> seventh = new Node<>("gg", null);

        //生成链表
        first.next = second;
        second.next = thirty;
        thirty.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        //seventh.next = thirty;

        System.out.println("当前链表是否有环：" + getCircle(first));
    }

    public boolean getCircle(Node first) {
        Node<String> fast = first;
        Node<String> slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
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
