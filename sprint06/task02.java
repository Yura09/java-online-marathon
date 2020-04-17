import java.math.BigDecimal;
import java.util.*;

public class Employee implements Comparable<Employee> {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return experience == employee.experience &&
                Objects.equals(name, employee.name) &&
                Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, basePayment);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", basePayment=" + basePayment +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return getPayment().compareTo(o.getPayment());
    }
}

class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        return new BigDecimal(coefficient).multiply(super.getPayment());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }

    @Override
    public String toString() {
        return "Manager{" + "name='" + getName() + '\'' +
                ", experience=" + getExperience() +
                ", basePayment=" + getPayment() +
                ", coefficient=" + coefficient +
                '}';
    }
}

class MyUtils {
    public static void main(String[] args) {
       
        Employee e1 = new Employee("Ivan", 10, BigDecimal.valueOf(3000.00));
        Manager m1 = new Manager("Petro", 9, BigDecimal.valueOf(3000), 1.5);

        Employee e2 = new Employee("Stepan", 8, BigDecimal.valueOf(4000.00));
        Employee e3 = new Employee("Andriy", 7, BigDecimal.valueOf(3500.00));
        Employee e4 = new Employee("Ihor", 5, BigDecimal.valueOf(4500.00));
        Manager m2 = new Manager("Vasyl", 8, BigDecimal.valueOf(2000.00), 2.0);
        List<Employee> list = new ArrayList<>();
        list.add(null);
        list.add(m1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(m2);
        System.out.println(new MyUtils().largestEmployees(list));

    }

    public List<Employee> largestEmployees(List<Employee> workers) {

        Set<Employee> employeeSet = new HashSet<>();
        Integer maxExperienceYear = workers.stream().distinct().filter(Objects::nonNull).max(Comparator.comparing(Employee::getExperience)).map(Employee::getExperience).orElse(0);
        BigDecimal maxBasePayment = workers.stream().distinct().filter(Objects::nonNull).max(Comparator.comparing(Employee::getPayment)).map(Employee::getPayment).orElse(BigDecimal.valueOf(0));
        for (Employee worker : workers) {
            if (worker != null && (worker.getExperience() >= maxExperienceYear || worker.getPayment().compareTo(maxBasePayment) >= 0)) {
                employeeSet.add(worker);
            }
        }

        return new ArrayList<>(employeeSet);

    }
}
