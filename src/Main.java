public class Main {

    public static void main(String[] args) {
        long minPossibleSalary = 2000L;
        Employee employee1 = new Employee("Ivan", "12345678", 1800);
        Employee employee2 = new Employee("Kate", "12345678", 3100);
        Employee employee3 = new Employee("Petro", "12345678", 2500);
        Employee employee4 = new Employee("Carl", "12345678", 1600);
        Employee newEmployee = new Employee("Jane", "380963927421", 1950);

        Company company = new Company("GL", "Kyiv", "1234567890",
                new Employee[]{employee1, employee2, employee3, employee4});

        CompanyUtils companyUtils = new CompanyUtils();
        String employeeName = companyUtils.findEmployeeHighSalary(company);
        System.out.println("1. An employee with the highest salary is - " + employeeName);

        company = companyUtils.addNewEmployee(company, newEmployee, minPossibleSalary);
        System.out.println("2. An employee " + newEmployee.getName() + " is added to the company " + company.getName());

        System.out.print("Updated list of company's employees is: ");
        for (Employee employee : company.getEmployees()) {
            System.out.print(employee + ", ");
        }
        System.out.println();

        company = companyUtils.removeSomeEmployee(company, employee3);
        System.out.println("3. An employee " + employee3.getName() + " is removed from the company " + company.getName());

        System.out.print("Updated list of company's employees is: ");
        for (Employee employee : company.getEmployees()) {
            System.out.print(employee + ", ");
        }
        System.out.println();

        System.out.println("4. Expenses amount for company " + company.getName()
                + " : " + companyUtils.calculateExpensesAmount(company));

        System.out.println("5. Average salary in the company " + company.getName()
                + " : " + companyUtils.calculateAvgSalary(company));



    }
}