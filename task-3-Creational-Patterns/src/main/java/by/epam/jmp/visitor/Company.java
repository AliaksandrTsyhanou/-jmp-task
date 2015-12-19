package by.epam.jmp.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class Company implements Element{

    private List<Employee> employees = new ArrayList<>();

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employees) {
        this.employees.add(employees);
    }
}
