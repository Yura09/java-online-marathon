class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter;

        private Iterator() {
            counter = 0;
        }

        public boolean hasNext() {
            return counter < names.length;
        }
        public String next(){
            return names[counter++];

        }
    }
    // Write your code here

}
