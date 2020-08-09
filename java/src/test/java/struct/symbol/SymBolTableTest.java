package struct.symbol;

import org.junit.Test;

public class SymBolTableTest {
    @Test
    public void test() {
        SymbolTable<Integer, String> symbol = new SymbolTable<>();
        symbol.put(1, "欧阳克");
        symbol.put(2, "黄蓉");
        symbol.put(3, "洪七公");
        symbol.put(4, "郭靖");
        symbol.put(5, "杨康");

        System.out.println("有序表的数据个数为：" + symbol.size());

        symbol.put(5, "穆念慈");

        String result = symbol.get(5);
        System.out.println("获取的5号人物为：" + result);

        symbol.delete(5);
        System.out.println("删除后元素个数为：" + symbol.size());
    }
}
