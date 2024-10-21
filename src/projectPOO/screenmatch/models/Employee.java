package projectPOO.screenmatch.models;

import projectPOO.screenmatch.enums.EmployeePosition;

public class Employee {
    private String name;
    private EmployeePosition employeePosition;

    public Employee(EmployeePosition employeePosition, String name) {
        this.employeePosition = employeePosition;
        this.name = name;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public String getName(){
        return name;
    }
}
