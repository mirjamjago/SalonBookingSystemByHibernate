package menu;

import model.Booking;
import model.Customer;
import persistence.RepositoryBooking;
import persistence.RepositoryCustomer;

import java.util.List;
import java.util.Scanner;

public class MenuBooking {

    RepositoryBooking repositoryBooking = new RepositoryBooking();
    RepositoryCustomer repositoryCustomer = new RepositoryCustomer();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all bookings");
        System.out.println("2: Create a booking");
        System.out.println("3: Total number of Bookings");
        System.out.println("4: Active and NotActive Bookings");
        System.out.println("5: Total Bookings by person ID");
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
                    menuListAllBookings(input);
                    break;
                case 2:
                    menuCreateBooking(input);
                    break;
                case 3:
                    menuTotalBookings(input);
                    break;
                case 4:
                    menuTotalActiveAndNotActiveBookings(input);
                    break;
                case 5:
                    menuTotalBookingsByCustomer(input);
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

    private void menuCreateBooking(Scanner input) {
        Booking booking = new Booking();
        ValidationFacility validationFacility = new ValidationFacility();
        int customerID = validationFacility.RegisterId(input, "Customer");
        Customer customer = repositoryCustomer.searchByID(customerID);
        //TODO WHILE STATEMENT
        if (customer == null) {
            System.out.println("Customer with ID: " + customerID + " not found. Please create Customer before booking");
        } else {
            booking.setCustomer(customer);
            booking.setStatus(validationFacility.RegisterStatus(input));
            repositoryBooking.create(booking);
        }
    }


    private void menuListAllBookings(Scanner input) {
        List<Booking> listBooking = repositoryBooking.getAllBookings();

        if (listBooking.size() > 0) {
            System.out.println("\nList of Customers:");
            for (Booking booking : listBooking) {
                System.out.println(booking.toString());
            }
        } else {
            System.out.println("\nNo customers registered\n");
            menuOptions(input);
        }
    }

    public void menuTotalBookings(Scanner input) {
        List<Booking> bookingList = repositoryBooking.getAllBookings();
        if (bookingList.size() > 0) {
            long totalBookings = repositoryBooking.totalBookings();
            System.out.println("We have currently " + totalBookings + " bookings in the system");
        } else {
            System.out.println("\nNo bookings registered\n");
            menuOptions(input);
        }
    }


    public void menuTotalActiveAndNotActiveBookings(Scanner input) {
        List<Booking> bookingList = repositoryBooking.getAllBookings();
        if (bookingList.size() > 0) {
            List<Object[]> activeBookings = repositoryBooking.totalActiveAndNotActiveBookings();
            Object[] result = activeBookings.get(0);
            Object[] result1 = activeBookings.get(1);
            System.out.println((String) result[0] + " " + (long) result[1]);
            System.out.println((String) result1[0] + " " + (long) result1[1]);
        } else {
            System.out.println("\nNo bookings registered\n");
            menuOptions(input);
        }
    }

    public void menuTotalBookingsByCustomer(Scanner input) {
        List<Booking> bookingList = repositoryBooking.getAllBookings();
        if (bookingList.size() > 0) {
            System.out.println("Insert the CustomerId");
            int customerID = input.nextInt();
            long totalBookingsByCustomer = repositoryBooking.totalBookingsByCustomerName(customerID);
            System.out.println("Customer with ID: " + customerID + " have done " + totalBookingsByCustomer + " bookings in the system");
        } else {
            System.out.println("\nNo bookings registered\n");
            menuOptions(input);
        }
    }


}
