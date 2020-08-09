package struct.queue;

import org.junit.Test;

public class QueueTest {

    @Test
    public void test() {
        Queue<String> q = new Queue<>();
        q.enQueue("a");
        q.enQueue("b");
        q.enQueue("c");
        q.enQueue("d");
        for (String str : q) {
            System.out.println(str);
        }

        System.out.println("------------------------------");
        String result = q.deQueue();
        System.out.println("出队的值为：" + result);
        System.out.println("出队后，剩余元素个数为" + q.size());
    }

}
