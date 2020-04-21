// Describe LineType enum here
enum LineType {
    SOLID("solid"), DOTTED("dotted"), DASHED("dashed"), DOUBLE("double");
    String type;

    LineType(String type) {
        this.type = type;
    }

    public String getName() {
        return type;
    }
}

  public static String drawLine(LineType lineType) {

        // Write method code here
        return "The line is " + lineType.getName() + " type";

    }
