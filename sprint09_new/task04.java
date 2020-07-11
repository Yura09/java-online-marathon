public static String readFile(String filename) {
     FileReader fr;
        try {
            fr = new FileReader(filename);

            java.util.Scanner scan = new java.util.Scanner(fr);
            String str = scan.nextLine();
            String[] tokens = str.split("(?<=\\G.{" + 7 + "})");
            StringBuilder stringBuilder = new StringBuilder();
            for (String binary_string : tokens) {
                char c = (char) Integer.parseInt(binary_string, 2);
                stringBuilder.append(c);
            }
            fr.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    
}
