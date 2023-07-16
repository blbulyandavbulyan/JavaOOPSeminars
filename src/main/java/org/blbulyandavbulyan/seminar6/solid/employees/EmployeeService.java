package org.blbulyandavbulyan.seminar6.solid.employees;

public class EmployeeService {

    private double cfx;

    public EmployeeService(double cfx) {
        this.cfx = cfx;
    }

    public EmployeeService() {
        this(0.25);
    }
    public int calculateNetSalary(Employee employee) {
        int baseSalary = employee.getBaseSalary();
        int tax = (int)(baseSalary * cfx);//calculate in otherway
        return baseSalary - tax;
    }
}
