import java.util.Arrays;
import java.util.Comparator;

class PersonComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        int res = ((Person)o1).getName().compareTo(((Person)o2).getName());
        return res != 0 ? res : ((Person)o1).age - ((Person)o2).age;
    }
}

class EmployeeComparator implements Comparator<Object> {
    private static Comparator<Person> personComparator = Comparator.comparing(Person::getName).thenComparing(Person::getAge);

    @Override
    public int compare(Object o1, Object o2) {
        if (personComparator.compare((Employee)o1,(Employee) o2) == 0) {
            return Double.compare(((Employee)o1).getSalary(), ((Employee)o2).getSalary());
        }
        return personComparator.compare((Employee)o1, (Employee)o2);
    }
}

class DeveloperComparator implements Comparator<Object> {
    private static Comparator<Employee> employeeComparator
            = Comparator.comparing(Employee::getName).thenComparing(Employee::getAge).thenComparing(Employee::getSalary);
  
    @Override
    public int compare(Object o1, Object o2) {
        if (employeeComparator.compare((Developer) o1, (Developer) o2) == 0) {
            return ((Developer)o1).getLevel().compareTo(((Developer)o2).getLevel());
        }
        return employeeComparator.compare((Developer)o1, (Developer)o2);
    }
}
 class Utility {
    public static<T extends Person> void sortPeople(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);

    }

    public static void main(String[] args) {
        Utility.sortPeople(new Person[]{new Employee("asd",12,123)},new EmployeeComparator());
    }
}
