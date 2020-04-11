package Test;

import org.passay.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {


    public static boolean checkingPass (String pass) {
        PasswordData data = new PasswordData ();
        data.setPassword (pass);
        CharacterCharacteristicsRule listOfRules = new CharacterCharacteristicsRule (4,
                new CharacterRule(EnglishCharacterData.Digit),
                new CharacterRule(EnglishCharacterData.LowerCase),
                new CharacterRule(EnglishCharacterData.UpperCase),
                new CharacterRule(EnglishCharacterData.Special)
        );

        org.passay.PasswordValidator validator = new org.passay.PasswordValidator(listOfRules, new LengthRule (8,16));
        RuleResult result = validator.validate (data);
        return result.isValid ();
//        String patternString = "(?=.*[0-9])(?=.*[!@#$%^&*_-])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{4,8}";
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher(pass);
//        return matcher.matches();

    }


}
