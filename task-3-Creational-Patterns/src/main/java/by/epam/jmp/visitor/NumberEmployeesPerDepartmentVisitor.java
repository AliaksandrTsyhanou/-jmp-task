package by.epam.jmp.visitor;

import java.util.stream.Collectors;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class NumberEmployeesPerDepartmentVisitor implements Visitor {

    @Override
    public void visit(Company company) {
        System.out.println("Number of employees per department = " +
            company.getEmployees().stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
    }
}
