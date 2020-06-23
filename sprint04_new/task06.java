class PersonComparator implements Comparator<Person> {
    static Comparator<Person> COMPARATOR = Comparator.comparing(Person::getName)
            .thenComparing(Person::getAge);

    @Override
    public int compare(Person o1, Person o2) {
        return COMPARATOR.compare(o1, o2);
    }
}

class EmployeeComparator implements Comparator<Employee> {
    static Comparator<Employee> COMPARATOR = Comparator.<Employee, Person>comparing(Person.class::cast, PersonComparator.COMPARATOR).thenComparing(Employee::getSalary);


    @Override
    public int compare(Employee o1, Employee o2) {
        return COMPARATOR.compare(o1, o2);
    }
}

class DeveloperComparator implements Comparator<Developer> {
    static Comparator<Developer> COMPARATOR = Comparator.<Developer, Employee>comparing(Employee.class::cast, EmployeeComparator.COMPARATOR).thenComparing(Developer::getLevel);
    @Override
    public int compare(Developer o1, Developer o2) {
        return COMPARATOR.compare(o1,o2);
    }
}

class Utility {
    
   public static <T extends Person> void sortPeople(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);

    }
    
}
