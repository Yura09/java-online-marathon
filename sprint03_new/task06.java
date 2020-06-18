import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

enum SortOrder {
    ASC, DESC;
}

public class AddressBook implements Iterable {
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public int size() {
        return counter;
    }

    public boolean create(String firstName, String lastName, String address) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
        if (counter == addressBook.length) {
            ensureCapacity();
        }
        for (int i = 0; i < size(); i++) {
            if (addressBook[i].person.equals(person)) {
                return false;
            }
        }
        addressBook[counter++] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
        return true;
    }

    public String read(String firstName, String lastName) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < size(); i++) {
            if (addressBook[i].person.equals(person)) {
                return addressBook[i].address;
            }
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);

        for (int i = 0; i < size(); i++) {
            if (addressBook[i].person.equals(person)) {
                addressBook[i].address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < size(); i++) {
            if (addressBook[i].person.equals(person)) {

                for (int j = i; j < size() - 1; j++) {
                    addressBook[j] = addressBook[j + 1];
                }
                counter--;
                return true;
            }
        }
        return false;

    }

    public void sortedBy(SortOrder order) {
        Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
            @Override
            public int compare(NameAddressPair o1, NameAddressPair o2) {
                if (order.equals(SortOrder.ASC)) {
                    if (o1.person.firstName.equals(o2.person.firstName)) {
                        return o1.person.lastName.compareTo(o2.person.lastName);
                    } else {
                        return o1.person.firstName.compareTo(o2.person.firstName);
                    }
                }
                if (order.equals(SortOrder.DESC)) {
                    if (o1.person.firstName.equals(o2.person.firstName)) {
                        return -o1.person.lastName.compareTo(o2.person.lastName);
                    } else {
                        return -o1.person.firstName.compareTo(o2.person.firstName);
                    }
                }
                return 0;
            }
        });
    }

    private void ensureCapacity() {
        int newSize = addressBook.length * 2;
        addressBook = Arrays.copyOf(addressBook, newSize);
    }

    @Override
    public Iterator iterator() {
        return new AddressBookIterator();
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        @Override
        public String toString() {
            return "First name: " + person.firstName + ", Last name: " + person.lastName + ", Address: " + address;
        }

        private static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person)) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) &&
                        Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }

        }
    }

    private class AddressBookIterator implements Iterator<String> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size();
        }

        @Override
        public String next() {
            return addressBook[counter++].toString();
        }

    }

}
