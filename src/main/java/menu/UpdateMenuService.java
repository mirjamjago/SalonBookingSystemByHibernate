package menu;

import model.Service;
import persistence.RepositoryService;

import java.util.Scanner;


public class UpdateMenuService {
    RepositoryService repositoryService = new RepositoryService();

    private int updateMenuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the Update menu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Change Service Name");
        System.out.println("2: Change Service Description");
        System.out.println("3: Change Service Price");
        System.out.println("4: Change Service Duration Time");
        System.out.println("100 - Return to Service Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void updateMenuChoice(Scanner input) {
        System.out.println("Type the Service ID: ");
        int serviceID = input.nextInt();
        Service service = repositoryService.searchByID(serviceID);
        ValidationFacility validationService = new ValidationFacility();
        if (service == null) {
            System.out.println("There are currently no services registered with ID: " + serviceID);
        } else {
            int userChoice;
            do {
                userChoice = updateMenuOptions(input);
                switch (userChoice) {
                    case 1:
                        service.setName(validationService.RegisterName(input, "Service Name"));
                        repositoryService.update(service);
                        System.out.println("Service name with ID: " + serviceID +" is updated successfully!");
                        break;
                    case 2:
                        service.setDescription(input.next());
                        repositoryService.update(service);
                        System.out.println("Service description with ID: " + serviceID +" is updated successfully!");
                        break;
                    case 3:
                        service.setPrice(validationService.RegisterPrice(input));
                        repositoryService.update(service);
                        System.out.println("Service price with ID: " + serviceID +" is updated successfully!");
                        break;
                    case 4:
                        service.setDuration(validationService.RegisterDuration(input));
                        repositoryService.update(service);
                        System.out.println("Service duration time with ID: " + serviceID +" is updated successfully!");
                        break;
                    case 5:
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
