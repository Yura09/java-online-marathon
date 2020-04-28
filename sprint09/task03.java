
import java.util.Arrays;
import java.util.ArrayList;

 class MyUtils {


      public  String pigLatinConverter(String text) {
        // Code
        if (text.isEmpty()) {
            return text;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isPunctuation = false;
        char punctuation = ' ';
       
      
        if (!Character.isLetterOrDigit(text.charAt(text.length() - 1))) {
            isPunctuation = true;
            punctuation = text.charAt(text.length() - 1);
        }


        String[] words = text.split("[, -?.!@]+");
        for (String word : words) {
            if (isFirstWordVowel(word)) {

                stringBuilder.append(word).append("hay").append(" ");
            } else {
                StringBuilder con = new StringBuilder();
                if (word.indexOf('-') != -1) {

                }
                String vowels = "aeiou";

                for (int i = 0; i < word.length(); i++) {

                    if (vowels.indexOf(Character.toLowerCase(word.charAt(i))) == -1) {
                        con.append(word.charAt(i));
                        continue;
                    }
                    break;
                }
                stringBuilder.append(word.substring(con.length())).append(con).append("ay").append(" ");
            }
        }
        if (isPunctuation) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(punctuation);
        }
        return stringBuilder.toString().trim();
    }

    public static boolean isFirstWordVowel(String word) {
        String vowels = "aeiou";
        return vowels.indexOf(Character.toLowerCase(word.charAt(0))) != -1;
    }
}
