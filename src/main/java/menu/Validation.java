package menu;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public boolean validateEmail(String email) {
        String emailPattern =
                "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

   public boolean validateName(String name){
        String namePatter =
                "^(?=.{3,20}$)[a-zäöüõA-ZÄÖÜÕ]+(?:[-'\s][a-zäöüõA-ZÄÖÜÕ]+)*$";
        Pattern pattern = Pattern.compile(namePatter);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
   }

   public boolean validatePhoneNumber(String phoneNumber){
        String phoneNumberPattern = "^[0-9]{4,15}";
        Pattern pattern = Pattern.compile(phoneNumberPattern);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
   }

   public boolean validateAddress(String address){
        String addressPattern = "^[a-zäöüõA-ZÄÖÜÕ0-9_.-]*$";
        Pattern pattern = Pattern.compile(addressPattern);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
   }


}
