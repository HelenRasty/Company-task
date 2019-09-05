import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class CompanyUtils {
    Scanner scanner = new Scanner(System.in);

    public String findEmployeeHighSalary(Company company) {
        Employee[] employees = company.getEmployees();
        long maxSalary = 0;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalaryEmployee = employee;
                maxSalary = employee.getSalary();
            }
        }
        return maxSalaryEmployee.getName();
    }

    public boolean isUserAnswerYes(){
        boolean flag;
        String answer = scanner.nextLine();
        if (answer.contentEquals("y") || (answer.contentEquals("yes"))) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public Company addNewEmployee(Company company, Employee employee, Long minPossibleSalary) {
        Employee[] employees = company.getEmployees();
        Employee[] employeesNewArray = Arrays.copyOf(employees, employees.length + 1);

        employeesNewArray[employeesNewArray.length - 1] = employee;

        if (employee.getSalary() >= minPossibleSalary) {
            System.out.println("   Status: OK. Employee's salary " +
                    employee.getSalary() + " is >= min possible salary in the company " + minPossibleSalary);
            company.setEmployees(employeesNewArray);
        } else {
            System.out.println("   Status: ERROR. Employee's salary " +
                    employee.getSalary() + " is < min possible salary in the company " + minPossibleSalary
                    + ". The Salary is changed to min possible!");
            employee.setSalary(minPossibleSalary);
            company.setEmployees(employeesNewArray);
        }

        return company;
    }

    public Company removeSomeEmployee(Company company, Employee employee) {
        int tmp = 0;
        Employee[] employees = company.getEmployees();
        Employee[] employeesNewArray = new Employee[employees.length - 1];

        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i] == employee) {
                employeesNewArray[i] = employees[i + 1];
                tmp++;
            } else {
                employeesNewArray[i] = employees[i + tmp];
            }
        }

        company.setEmployees(employeesNewArray);
        return company;
    }

    public long calculateExpensesAmount(Company company) {
        long expAmount = 0;
        Employee[] employees = company.getEmployees();

        for (int i = 0; i < employees.length; i++) {
            expAmount = employees[i].getSalary() + expAmount;
        }

        return expAmount;
    }

    public BigDecimal calculateAvgSalary(Company company) {
        long expAmount = 0;
        BigDecimal avgSalary;
        Employee[] employees = company.getEmployees();

        for (int i = 0; i < employees.length; i++) {
            expAmount = employees[i].getSalary() + expAmount;
        }

        avgSalary = BigDecimal.valueOf(expAmount).divide(BigDecimal.valueOf(employees.length), 2, RoundingMode.HALF_UP);
        return avgSalary;
    }

}