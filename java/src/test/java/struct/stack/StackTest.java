package struct.stack;

import org.junit.Test;

public class StackTest {

    @Test
    public void test() {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");

        for (String item : s) {
            System.out.println(item);
        }

        System.out.println("-------------------------------");

        String result = s.pop();

        System.out.println("弹出来的元素为：" + result);
        System.out.println("剩余的元素个数为：" + s.size());
    }
}
