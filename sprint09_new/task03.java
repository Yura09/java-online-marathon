public static void writeFile(String filename, String text) {

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : text.toCharArray()) {

            stringBuilder.append(("0000000" + Integer.toBinaryString(ch)).substring(Integer.toBinaryString(ch).length()));
        }

        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            writer.print(stringBuilder.toString());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    
}
