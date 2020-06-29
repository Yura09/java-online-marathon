public static Plant tryCreatePlant(String type, String color, String name) throws TypeException, ColorException {
        try {
            return new Plant(type, color, name);
        } catch (ColorException e) {
            try {
                return new Plant(type, "Red", name);
            } catch (TypeException ex) {
                return new Plant("Ordinary", "Red", name);
            }
        } catch (TypeException e) {
            try {
                return new Plant("Ordinary", color, name);
            } catch (ColorException ex) {
                return new Plant("Ordinary", "Red", name);
            }
        }
    }
