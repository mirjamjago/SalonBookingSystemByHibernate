package menu;

import model.Employee;
import model.Person;
import persistence.RepositoryEmployee;

import java.util.List;
import java.util.Scanner;

public class MenuEmployee {
    RepositoryEmployee repositoryEmployee = new RepositoryEmployee();
    ValidationFacility validationFacility = new ValidationFacility();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all employees");
        System.out.println("2: Create new employee");
        System.out.println("3: Delete employee from the system");
        System.out.println("4: Update the employee information");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuListAllEmployees(input);
                    break;
                case 2:
                    menuRegisterEmployee(input);
                    break;
                case 3:
                    menuDeleteEmployee(input);
                    break;
                case 4:
                    menuUpdate(input);
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }

    public void menuRegisterEmployee(Scanner input) {
        Employee employee = new Employee();
        Person person = new Person();
        person.setFirstName(validationFacility.RegisterName(input, "Fisrt Name"));
        person.setLastName(validationFacility.RegisterName(input, "Last Name"));
        person.setPhoneNumber(validationFacility.RegisterPhoneNumber(input));
        person.setEmail(validationFacility.RegisterEmail(input));
        employee.setAddress(validationFacility.RegisterAddress(input));
        employee.setPerson(person);
        System.out.println("Employee created");
        repositoryEmployee.create(employee);
    }

    private void menuListAllEmployees(Scanner input) {
        List<Employee> listEmployee = repositoryEmployee.getAllEmployees();

        if (listEmployee.size() > 0) {
            System.out.println("\nList of Employees:");
            for (Employee employee : listEmployee) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("\nNo employees registered\n");
            menuOptions(input);
        }
    }

    private void menuUpdate(Scanner input){
        UpdateMenuEmployee updateMenuEmployee = new UpdateMenuEmployee();
        updateMenuEmployee.updateMenuChoice(input);
    }

    private void menuDeleteEmployee(Scanner input){
        System.out.println("Type the Employee ID for Deleting: ");
        int employeeId = validationFacility.RegisterId(input, "Employee");
        Employee employee = repositoryEmployee.searchByID(employeeId);
        if(employee == null){
            System.out.println("There are no such employee with ID:" + employeeId);
        }else {
            repositoryEmployee.delete(employee);
            System.out.println("Employee successfully deleted from the System");
        }
    }


}


