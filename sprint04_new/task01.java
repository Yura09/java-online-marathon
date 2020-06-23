import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Objects;
public class MyUtils {
    
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
         Map<String, List<String>> noteBook = new HashMap<>();

        for (Map.Entry<String, String> entry : phones.entrySet()) {
            
            if (!noteBook.containsKey(entry.getValue())) {
                noteBook.put(entry.getValue(), new ArrayList<>());
            }
            List<String> numbers = noteBook.get(entry.getValue());
            numbers.add(entry.getKey());
            noteBook.put(entry.getValue(), numbers);
        }
           return noteBook;
   }

}
