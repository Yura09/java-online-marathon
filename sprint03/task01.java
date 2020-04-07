 import java.util.Arrays;
import java.util.Comparator;


public class MyUtils {
 public static int[][] arrSort(int[][] arr) {
        Arrays.sort(arr, (entry1, entry2) -> {

            if (entry1.length == 0) {
                return 1;
            }
            if (entry2.length == 0) {
                return -1;
            }
            if (entry1[0] == entry2[0]) {
                if (entry1.length == 1) {
                    return -1;
                }
                if (entry2.length == 1) {
                    return 1;
                }
                return -(entry2[1] - entry1[1]);
            }
            return entry2[0] - entry1[0];
        });
        return arr;
        // Code
      }
    }
