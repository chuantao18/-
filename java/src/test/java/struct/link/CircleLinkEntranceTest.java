package struct.link;

import org.junit.Test;

public class CircleLinkEntranceTest {
    @Test
    public void test() {

        //新建节点
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> thirty = new Node<>("cc", null);
        Node<String> fouth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> sixth = new Node<>("ff", null);
        Node<String> seventh = new Node<>("gg", null);

        //生成链表
        first.next = second;
        second.next = thirty;
        thirty.next = fouth;
        fouth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = fouth;

        System.out.println("当前链表环入口值为：" + getCircle(first).item);
    }

    public Node getCircle(Node first) {
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                temp = first;
                continue;
            }
            if (temp != null) {
                temp = temp.next;
                if (temp.equals(slow)) {
                    break;
                }
            }
        }
        return temp;
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
