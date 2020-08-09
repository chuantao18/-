package struct.link;

import org.junit.Test;

public class JosephTest {

    @Test
    public void test() {
        Node<Integer> first = null;
        Node<Integer> pre = null;

        //生成41个节点的循环链表
        for (int i = 1; i <= 41; i++) {
            //第一个节点
            if (i == 1) {
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            //如果不是第一个节点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            //如果是最后一个节点
            if (i == 41) {
                pre.next = first;
            }
        }

        //模拟约瑟夫报数
        int count = 0;
        //遍历循环链表，记录每次的节点，默认从首节点开始
        Node<Integer> n = first;
        //记录当前节点的前一个节点
        Node<Integer> before = null;
        while (n != n.next) {
            count++;
            if (count == 3) {
                //如果当前计数是3
                //删除这个节点，重置计数，节点下移
                before.next = n.next;
                System.out.print(n.item + ", ");
                count = 0;
                n = n.next;
            } else {
                //如果当前不是3，当前节点变为before，当前节点移动到下一个节点
                before = n;
                n = n.next;
            }
        }
        System.out.println(n.item);
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
