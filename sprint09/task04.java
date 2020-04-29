import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.ArrayList;


public class MyUtils {
    public String differentWords(String originalText, String modifyText) {
       String[] originalWords = originalText.split("([, ?.!@]+)");
        String[] modifyWords = modifyText.split("([, ?.!@]+)");
        List<String> originalSet = new ArrayList<>(Arrays.asList(originalWords));
        List<String> modifySet = new ArrayList<>(Arrays.asList(modifyWords));

        originalSet.forEach(modifySet::remove);
      
       
       for (String s : modifySet) {
            if (s.length() == 1) {
                modifyText = modifyText.replaceAll("\\b\\b" + s, s.toUpperCase());
                continue;
            }
            int i = modifyText.indexOf(s);
            int j = modifyText.lastIndexOf(s);
           
            if (i!=j && originalText.charAt(i)==modifyText.charAt(i)) {
                String cur = modifyText.replace(modifyText.substring(modifyText.lastIndexOf(s)), s.toUpperCase());
                modifyText = cur + modifyText.substring(modifyText.lastIndexOf(s) + s.length());

            }else {
                modifyText = modifyText.replaceFirst(s, s.toUpperCase());
            }

        }

        return modifyText;
    }
}
