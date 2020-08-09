package struct.symbol;

import org.junit.Test;

public class OrderSymbolTableTest {
    @Test
    public void test() {
        OrderSymbolTable<Integer, String> table = new OrderSymbolTable<>();
        table.put(1, "欧阳克");
        table.put(2, "黄蓉");

        table.put(4, "郭靖");
        table.put(7, "杨康");


        table.put(3, "洪七公");
    }
}
