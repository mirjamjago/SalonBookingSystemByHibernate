package menu;

import model.Employee;
import model.Person;
import model.Service;
import persistence.RepositoryEmployee;
import persistence.RepositoryService;

import java.util.Scanner;

public class UpdateMenuEmployee {

    RepositoryEmployee repositoryEmployee = new RepositoryEmployee();

    private int updateMenuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the Update menu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Change Employee First Name");
        System.out.println("2: Change Employee Last Name");
        System.out.println("3: Change Employee Phone Number");
        System.out.println("4: Change Employee email");
        System.out.println("5: Change Employee Address");
        System.out.println("100 - Return to Service Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void updateMenuChoice(Scanner input) {
        ValidationFacility validationFacility = new ValidationFacility();
        int employeeID = validationFacility.RegisterId(input, "Employee");
        Employee employee = repositoryEmployee.searchByID(employeeID);
        if (employee == null) {
            System.out.println("There are currently no employees registered with this ID: " + employeeID);
        } else {
            int userChoice;
            do {
                userChoice = updateMenuOptions(input);
                switch (userChoice) {
                    case 1:
                        employee.getPerson().setFirstName(validationFacility.RegisterName(input, "Fisrt Name"));
                        repositoryEmployee.update(employee);
                        System.out.println("Employee with ID: " + employeeID +" first name is updated successfully!");
                        break;
                    case 2:
                        employee.getPerson().setLastName(validationFacility.RegisterName(input, "Last Name"));
                        repositoryEmployee.update(employee);
                        System.out.println("Employee with ID: " + employeeID +" last name is updated successfully!");
                        break;
                    case 3:
                        employee.getPerson().setPhoneNumber(validationFacility.RegisterPhoneNumber(input));
                        repositoryEmployee.update(employee);
                        System.out.println("Employee with ID: " + employeeID +" phone number is updated successfully!");
                        break;
                    case 4:
                        employee.getPerson().setEmail(validationFacility.RegisterEmail(input));
                        repositoryEmployee.update(employee);
                        System.out.println("Employee with ID: " + employeeID +" email is updated successfully!");
                        break;
                    case 5:
                        employee.setAddress(validationFacility.RegisterAddress(input));
                        repositoryEmployee.update(employee);
                        System.out.println("Employee with ID: " + employeeID +" address is updated successfully!");
                        break;
                    case 100:
                        break;
                    default:
                        System.out.println("\nSorry, please enter valid Option");
                        updateMenuOptions(input);
                        break;
                }
            } while (userChoice != 100);
        }
    }
}
