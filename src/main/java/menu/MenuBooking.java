package menu;

import model.Booking;
import model.BookingsByCustomerAndPayment;
import persistence.RepositoryBooking;

import java.util.List;
import java.util.Scanner;

public class MenuBooking {

    RepositoryBooking repositoryBooking = new RepositoryBooking();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all bookings");
        System.out.println("2: Total Bookings");
        System.out.println("3: Active and NotActive Bookings");
        System.out.println("4: Total Bookings by person ID");
        System.out.println("5: Booking list By Customer and Payment");
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
                    menuTotalBookings(input);
                    break;
                case 3:
                    menuTotalActiveAndNotActiveBookings(input);
                    break;
                case 4:
                    menuTotalBookingsByCustomer(input);
                    break;
                case 5:
                    menuListOfBookingsByCustomerAndPayment(input);
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

    public void menuListOfBookingsByCustomerAndPayment(Scanner input) {
        List<Booking> bookingList = repositoryBooking.getAllBookings();
        if (bookingList.size() > 0) {
            List<BookingsByCustomerAndPayment> list = repositoryBooking.byCustomerAndPaymentList();
            System.out.println(list);
        } else{
            System.out.println("\nNo bookings registered\n");
            menuOptions(input);
        }
    }


}
