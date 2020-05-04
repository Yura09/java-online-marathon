class Plant{
    private  String name;
    private Color color;
    private Type type;

    public Plant(String type,String color,String name) throws ColorException, TypeException {
        this.name = name;
        try {
            this.color = Color.valueOf(color);
        }catch (IllegalArgumentException e){
            throw new ColorException(e.getMessage());
        }
      try {
          this.type = Type.valueOf(type);
      }catch (IllegalArgumentException e){
          throw new TypeException(e.getMessage());
      }
    }

    @Override
    public String toString() {
        return "{type: "+type+", color: "+color+", name: "+name+"}";
    }
}
class ColorException extends Exception{
    public ColorException(String message) {
        super(message);
    }
}
class TypeException extends Exception{
    public TypeException(String message) {
        super(message);
    }
}
enum Color{
    White,Red,Blue;
}
enum Type{
    Rare,Ordinary
}
