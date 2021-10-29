
import com.jakewharton.fliptables.FlipTable;

public class Tableshow {
    public static void ts(String [] headers, String[][] data) {
                System.out.println(FlipTable.of(headers, data));  //вывод таблицы, пусть пока тут полежит
    }
}
