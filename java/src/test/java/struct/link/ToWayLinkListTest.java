package struct.link;

import org.junit.Test;

public class ToWayLinkListTest {

    @Test
    public void testLink() {
        ToWayLinkList<String> link = new ToWayLinkList<>();
        link.insert("郭靖");
        link.insert("杨康");
        link.insert("穆念慈");
        link.insert("黄蓉");
        link.insert("洪七公");
        link.insert(1, "一灯");
        for (String s : link) {
            System.out.println(s);
        }
        String first = link.getFirst();
        System.out.println("获取的第一个元素为：" + first);
        String last = link.getLast();
        System.out.println("获取的最后一个元素为：" + last);

        System.out.println("------------------------------------");

        int index = link.indexOf("杨康");
        System.out.println("杨康在链表中第一次的位置为：" + index);

        String result = link.get(1);
        System.out.println("获取的值为：" + result);

        String remove = link.remove(1);
        System.out.println("删除值为：" + remove);

        link.clear();
        System.out.println("清空链表后，链表长度为" + link.length());

    }

}
