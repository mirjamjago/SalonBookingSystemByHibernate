package menu;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class SubMenuOptions {
    boolean exit = false;
    private final MenuCustomer menuCustomer;
    private final MenuEmployee menuEmployee;
    private final MenuService menuService;
    private final MenuBooking menuBooking;

    public SubMenuOptions() {
        this.menuCustomer = new MenuCustomer();
        this.menuEmployee = new MenuEmployee();
        this.menuService = new MenuService();
        this.menuBooking = new MenuBooking();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Main menu ");
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("1: Sub Menu - Customer");
        System.out.println("2: Sub Menu - Employee");
        System.out.println("3: Sub Menu - Service");
        System.out.println("4: Sub Menu - Booking");
        System.out.println("100 - Quit");
        System.out.println("***************************************************");

        System.out.println("Type the sub menu option: ");
        return input.nextInt();
    }

    public void menuChoice(Scanner input) {
        while(!exit) {
            int userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    this.menuCustomer.menuChoice(input);
                    break;
                case 2:
                    this.menuEmployee.menuChoice(input);
                    break;
                case 3:
                    this.menuService.menuChoice(input);
                    break;
                case 4:
                    this.menuBooking.menuChoice(input);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:

                    break;
                case 100:
                    exit = true;
                    closeTransaction(input);
                    System.out.println("System closed");
                    break;
//                default:
//                    System.out.println("\nSorry, please enter valid Option");
//                    menuChoice(input);
            }
        }
    }

private void closeTransaction(Scanner input){
        DBUtil dbUtil = new DBUtil();
        dbUtil.shutdown();
}

}
