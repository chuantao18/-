package struct.link;

import org.junit.Test;

public class LinkListReverseTest {

    @Test
    public void testLink() {
        LinkList<String> link = new LinkList<>();
        link.insert("郭靖");
        link.insert("杨康");
        link.insert("穆念慈");
        link.insert("黄蓉");
        link.insert("洪七公");
        link.insert(2, "一灯");
        for (String s : link) {
            System.out.println(s);
        }

        link.reverse();

        System.out.println("---------------反转后---------------------");

        for (String s : link) {
            System.out.println(s);
        }

    }

}
