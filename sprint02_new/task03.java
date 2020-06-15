import java.util.*;

 class Person {
 
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Student extends Person {
    // Code
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studyYears == student.studyYears &&
                Objects.equals(studyPlace, student.studyPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studyPlace, studyYears);
    }
}

class Worker extends Person {
    // Code
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return experienceYears == worker.experienceYears &&
                Objects.equals(workPosition, worker.workPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workPosition, experienceYears);
    }
}

class MyUtils {

    public List<Person> maxDuration(List<Person> persons) {
        // Code

        List<Person> maxPersons = new ArrayList<>();

        Integer maxExperienceYear = persons.stream()
                .filter(obj -> obj instanceof Worker).distinct()
                .map(obj -> (Worker) obj).max(Comparator.comparing(Worker::getExperienceYears)).map(Worker::getExperienceYears).orElse(0);
        Integer maxStudentYear = persons.stream().filter(obj -> obj instanceof Student)
                .distinct().map(obj -> (Student) obj).max(Comparator.comparing(Student::getStudyYears)).map(Student::getStudyYears).orElse(0);
        
        for (Person person : persons) {
            if (person instanceof Student && ((Student) person).getStudyYears() == maxStudentYear) {
                maxPersons.add(person);
            }
            if (person instanceof Worker && ((Worker) person).getExperienceYears() == maxExperienceYear) {
                maxPersons.add(person);
            }
        }

        return maxPersons;
    }
}
