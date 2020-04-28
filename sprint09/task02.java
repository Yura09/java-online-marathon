import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.regex.Pattern;
public class MyUtils {
    public boolean verifyBrackets(String text) {
          StringBuilder stringBuilder=new StringBuilder(Pattern.compile("\\\\.").matcher(text).replaceAll(""));
        // Initialize a stack to be used in the algorithm.
        text=stringBuilder.toString();
        Stack<Character> stack = new Stack<Character>();

         HashMap<Character, Character> mappings=new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);


            if (mappings.containsKey(c)) {


                char topElement = stack.empty() ? '#' : stack.pop();


                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {

                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
