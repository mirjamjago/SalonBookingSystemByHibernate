package menu;

import model.Booking;
import model.Service;
import persistence.RepositoryService;

import java.util.List;
import java.util.Scanner;

public class MenuService {

    RepositoryService repositoryService = new RepositoryService();
    ValidationFacility validationFacility = new ValidationFacility();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all services");
        System.out.println("2: Create new service");
        System.out.println("3: Update the Service");
        System.out.println("4: Delete the service");
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
                    menuListAllServices(input);
                    break;
                case 2:
                    menuRegisterService(input);
                    break;
                case 3:
                    menuUpdate(input);
                    break;
                case 4:
                    menuDelete(input);
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


    public void menuRegisterService(Scanner input) {
        Service service = new Service();
        service.setName(validationFacility.RegisterName(input, "Service Name"));
        System.out.println("Type Service Description: ");
        service.setDescription(input.next());
        service.setPrice(validationFacility.RegisterPrice(input));
        service.setDuration(validationFacility.RegisterDuration(input));
        repositoryService.create(service);
    }


    private void menuListAllServices(Scanner input) {
        List<Service> listService = repositoryService.getAllServices();

        if (listService.size() > 0) {
            System.out.println("\nList of Services:");
            for (Service service : listService) {
                System.out.println(service.toString());
            }
        } else {
            System.out.println("\nNo services registered\n");
            menuOptions(input);
        }
    }

    private void menuUpdate(Scanner input) {
        UpdateMenuService updateMenuService = new UpdateMenuService();
        updateMenuService.updateMenuChoice(input);
    }

    private void menuDelete(Scanner input){
        System.out.println("Type the Service ID for deleting");
        int serviceID = validationFacility.RegisterId(input, "Service");
        Service service = repositoryService.searchByID(serviceID);
        if(service == null){
            System.out.println("There are no services with ID:" + +serviceID);
        }else {
            repositoryService.delete(service);
            System.out.println("Service deleted from the system");
        }


    }
}