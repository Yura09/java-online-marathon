import java.util.Calendar;

class User {
    protected String name;
    protected String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

}

class Student extends User {
    protected int year;

    public Student(int year, String name, String surname) {
        super(name, surname);
        this.year = year;
    }

    public int getCourseNumber() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int result = currentYear - year + 1;

        return (result <= 6 && result >= 1) ? result : -1;
    }
}
