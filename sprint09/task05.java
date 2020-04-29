import java.util.StringTokenizer;
public class MyUtils {
 
        // Code
        public String addLinebreaks(String input, int maxLineLength) {
           
        StringTokenizer tok = new StringTokenizer(input, " ");
        StringBuilder output = new StringBuilder(input.length());
        int lineLen = 0;
        while (tok.hasMoreTokens()) {
            String word = tok.nextToken();

            if (lineLen + word.length() >= maxLineLength) {
                 output.deleteCharAt(output.length()-1);
                output.append("\n");
                lineLen = 0;
            }
            lineLen += word.length()+1;
            output.append(word).append(" ");

        }
        return output.toString();
    }
    public String reformatLines(String text) {
        // Code
       //  System.out.println(text);
        text = text.replaceAll("\\s+|\\n+", " ").trim();
        
        return addLinebreaks(text,60).trim();
    }
}
