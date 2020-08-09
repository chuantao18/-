package struct.link;

import org.junit.Test;

public class LinkListTest {

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

        System.out.println("------------------------------------");

        String result = link.get(1);
        System.out.println("获取的值为：" + result);

        String remove = link.remove(1);
        System.out.println("删除值为：" + remove);

        link.clear();
        System.out.println("清空链表后，链表长度为" + link.length());

    }

}
