import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
 class Employee {
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
    public List<Employee> largestEmployees(List<Employee> workers) {
        Integer maxExperienceYear = workers.stream().distinct().filter(Objects::nonNull).max(Comparator.comparing(Employee::getExperience)).map(Employee::getExperience).orElse(0);
        BigDecimal maxBasePayment = workers.stream().distinct().filter(Objects::nonNull).max(Comparator.comparing(Employee::getPayment)).map(Employee::getPayment).orElse(BigDecimal.valueOf(0));
        return workers.stream().distinct().filter(Objects::nonNull).filter(worker->worker.getExperience() >= maxExperienceYear || worker.getPayment().compareTo(maxBasePayment) >= 0).collect(Collectors.toList());
    }
}
