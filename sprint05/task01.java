abstract class Employee {
    protected String employeeID;

    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }

    public abstract String getFullInfo();
}

class SalariedEmployee extends Employee {
    protected String socialSecurityNumber;

    public SalariedEmployee(String employeeID, String socialSecurityNumber) {
        super(employeeID);
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String getFullInfo() {
        return employeeID + " " + socialSecurityNumber;
    }
}

class ContractEmployee extends Employee {
    protected String federalTaxIDMember;

    public ContractEmployee(String employeeID, String federalTaxIDMember) {
        super(employeeID);
        this.federalTaxIDMember = federalTaxIDMember;
    }

    @Override
    public String getFullInfo() {
        return employeeID + " " + federalTaxIDMember;
    }
}
