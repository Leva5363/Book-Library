package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {


    public static boolean checkingPass(String pass){
        String patternString = "(?=.*[0-9])(?=.*[!@#$%^&*_-])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{4,8}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();

    }
}
