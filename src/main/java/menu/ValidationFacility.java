package menu;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidationFacility {

    public String RegisterEmail(Scanner input) {
        Validation validation = new Validation();
        String email = null;
        boolean validForm = false;
        while (!validForm) {
            System.out.println("Type The Email: ");
            email = input.next();
            boolean emailResult = validation.validateEmail(email);
            if (!emailResult) {
                System.out.println("Inserted Email invalid");
            } else {
                validForm = true;
            }
        }
        return email;
    }

    public String RegisterPhoneNumber(Scanner input) {
        Validation validation = new Validation();
        String phoneNumber = null;
        boolean validForm = false;
        while (!validForm) {
            System.out.println("Type the Phone Number: ");
            phoneNumber = input.next();
            boolean phoneNumberResult = validation.validatePhoneNumber(phoneNumber);
            if (!phoneNumberResult) {
                System.out.println("Inserted Phone Number Is Invalid");
            } else {
                validForm = true;
            }
        }
        return phoneNumber;
    }

    public String RegisterAddress(Scanner input) {
        Validation validation = new Validation();
        String address = null;
        boolean validForm = false;
        while (!validForm) {
            System.out.println("Type the Address: ");
            address = input.next();
            boolean addressResult = validation.validateAddress(address);
            if (!addressResult) {
                System.out.println("Inserted Address Is Invalid");
            } else {
                validForm = true;
            }
        }
        return address;
    }

    public String RegisterName(Scanner input, String nameType) {
        Validation validation = new Validation();
        String name = null;
        boolean validForm = false;
        while (!validForm) {
            System.out.println("Type The " + nameType + ": ");
            name = input.next();
            boolean nameResult = validation.validateName(name);
            if (!nameResult) {
                System.out.println("Inserted " + nameType + " Is Invalid");
            } else {
                validForm = true;
            }
        }
        return name;
    }

    public BigDecimal RegisterPrice(Scanner input) {
        BigDecimal price;
        while (true) {
            try {
                System.out.println("Type The Price: ");
                price = input.nextBigDecimal();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Inserted Price is Invalid");
                input.next();
            }
        }
        return price;
    }

    public Integer RegisterDuration(Scanner input){
        int duration;
        while(true){
            try{
                System.out.println("Type the Duration Time in min: ");
                duration = input.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Inserted Duration Time is Invalid");
                input.next();
            }
        }
        return duration;
    }



}
