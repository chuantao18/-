package struct.tree;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void test() {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(1, "郭靖");
        tree.put(2, "洪七公");
        tree.put(3, "黄药师");
        tree.put(4, "一灯");

        System.out.println("树中元素的个数为：" + tree.size());

        System.out.println("获取2号树的值为：" + tree.get(2));

        tree.delete(4);

        System.out.println("删除元素，树中元素个数为：" + tree.size());

    }

}
