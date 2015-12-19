package by.epam.jmp.visitor;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class AverageSalaryVisitor implements Visitor {

    @Override
    public void visit(Company company) {
        System.out.println("Average salary = " +
            company.getEmployees().stream().mapToInt(Employee::getSalary).average().getAsDouble());
    }
}
