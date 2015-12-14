import by.epam.jmp.visitor.*;

import java.util.List;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class VisitorMain {

    public static void main(String[] args) {
        Company company = new Company();
        company.addEmployee(new Employee("Tom", 500, "QA"));
        company.addEmployee(new Employee("Kent", 800, "Dev"));
        company.addEmployee(new Employee("Vasia", 800, "Dev"));
        company.addEmployee(new Employee("Ivan", 400, "IT"));
        company.accept(new TotalSalariesVisitor());
        company.accept(new NumberEmployeesVisitor());
        company.accept(new AverageSalaryVisitor());
        company.accept(new NumberEmployeesPerDepartmentVisitor());
    }
}
