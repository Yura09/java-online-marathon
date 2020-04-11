        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        emp1.fullName="emp1";
        emp1.salary=1000;
        emp2.salary=2000;
        emp2.fullName="emp2";
        Employee[] employees = {emp1, emp2};
        String employeesInfo = "[";
        for (Employee employee : employees) {
            employeesInfo += "{fullName: \"" + employee.fullName + "\", salary: " + employee.salary + "}, ";
        }
        employeesInfo = employeesInfo.substring(0, employeesInfo.length() - 2);
        employeesInfo += "]";
