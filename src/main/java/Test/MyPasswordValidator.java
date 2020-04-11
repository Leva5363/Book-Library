package Test;

import org.passay.*;

public class MyPasswordValidator {


    public static boolean checkingPass (String pass) {
        int minCountCharacters = 8;
        int maxCountCharacters =16;

        PasswordValidator validator = new PasswordValidator(
                new CharacterRule(EnglishCharacterData.Digit),
                new CharacterRule(EnglishCharacterData.LowerCase),
                new CharacterRule(EnglishCharacterData.UpperCase),
                new CharacterRule(EnglishCharacterData.Special),
                new LengthRule (minCountCharacters,maxCountCharacters));

        RuleResult result = validator.validate (new PasswordData(pass));
        return result.isValid ();

    }


}
