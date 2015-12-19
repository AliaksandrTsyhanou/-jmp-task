package by.epam.jmp.visitor;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class NumberEmployeesVisitor implements Visitor {

    @Override
    public void visit(Company company) {
        System.out.println("Number of employees = " +
                company.getEmployees().size());
    }
}
