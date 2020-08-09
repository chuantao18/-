package struct.link;

import org.junit.Test;

public class FlowFastLinkTest {


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

        System.out.println("获取链表的中间值为：" + getMid(first));
    }

    public String getMid(Node first) {
        Node<String> fast = first;
        Node<String> low = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low.item;
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
