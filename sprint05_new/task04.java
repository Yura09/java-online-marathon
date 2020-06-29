import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String idCode;
   
    public Person(String firstName, String lastName, String idCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCode = idCode;
    }

    public Person() {
    }

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        Person person = new Person();
        String message="";
        try{
        person.setFirstName(firstName);
        }catch(NameException e){
            message+=e.getMessage();
        }try{
        person.setLastName(lastName);
        }catch(NameException e){
            message+=e.getMessage();
        }try{
        person.setIdCode(idCode);
        }catch(CodeException e){
            message+=e.getMessage();
        }
        if(!message.isEmpty()){
            throw new IllegalArgumentException(message.trim());
        }
        return person;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!firstName.matches("([A-Z][a-z_-]*)(\\s*)")) {
            throw new NameException("Incorrect value " + firstName + " for firstName (should start from upper case and contains only alphabetic characters and symbols -, _); ");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!lastName.matches("[A-Z][a-z_-]*(\\s*)")) {
            throw new NameException("Incorrect value " + lastName + " for firstName (should start from upper case and contains only alphabetic characters and symbols -, _); ");
        }
        this.lastName = lastName;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        if (!idCode.matches("\\d{10}")) {
            throw new CodeException("Incorrect value " + idCode + " for code (should contains exactly 10 digits)");
        }
        this.idCode = idCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return idCode == person.idCode &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }
}

class NameException extends RuntimeException {
    NameException(String message) {
        super(message);
    }
}

class CodeException extends RuntimeException {
    CodeException(String message) {
        super(message);
    }
}
