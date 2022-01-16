package menu;

import java.util.List;
import java.util.Scanner;
import model.Customer;
import model.Person;
import persistence.RepositoryCustomer;

public class MenuCustomer {
    RepositoryCustomer repositoryCustomer = new RepositoryCustomer();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all customers");
        System.out.println("2: Create new customer");
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
                    menuListAllCustomers(input);
                    break;
                case 2:
                    menuRegisterCustomer(input);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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


    public void menuRegisterCustomer(Scanner input) {
        Customer customer = new Customer();
        Person person = new Person();
        ValidationFacility validationService = new ValidationFacility();
        person.setFirstName(validationService.RegisterName(input, "First Name"));
        person.setLastName(validationService.RegisterName(input, "Last Name"));
        person.setPhoneNumber(validationService.RegisterPhoneNumber(input));
        person.setEmail(validationService.RegisterEmail(input));
        customer.setPerson(person);
        repositoryCustomer.create(customer);
    }


    private void menuListAllCustomers(Scanner input) {
        List<Customer> listCustomer = repositoryCustomer.getAllCustomers();

        if (listCustomer.size() > 0) {
            System.out.println("\nList of Customers:");
            for (Customer cust : listCustomer) {
                System.out.println(cust.toString());
            }
        } else {
            System.out.println("\nNo customers registered\n");
            menuOptions(input);
        }
    }



}
