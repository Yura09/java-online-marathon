import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class MyUtils {
    // Code
    public List<String> strSort(List<String> originList) {
        List<String> sortedList =new ArrayList<>(originList);
         sortedList.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareToIgnoreCase(o2);
            }
            return o1.length() - o2.length();
        });
        return sortedList;
    }
}
