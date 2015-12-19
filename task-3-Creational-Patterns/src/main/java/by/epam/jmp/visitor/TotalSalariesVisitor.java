package by.epam.jmp.visitor;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class TotalSalariesVisitor implements Visitor {

    @Override
    public void visit(Company company) {
        System.out.println("Total salaries computation = " +
            company.getEmployees().stream().mapToInt(Employee::getSalary).sum());
    }
}
