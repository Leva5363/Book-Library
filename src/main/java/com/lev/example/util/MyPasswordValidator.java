package com.lev.example.util;

import org.passay.*;

public class MyPasswordValidator {
    public final static int MIN_COUNT_CHARACTERS = 8;
    public final static int MAX_COUNT_CHARACTERS =16;


    public static boolean checkingPass (String pass) {
        PasswordValidator validator = new PasswordValidator(
                new CharacterRule(EnglishCharacterData.Digit),
                new CharacterRule(EnglishCharacterData.LowerCase),
                new CharacterRule(EnglishCharacterData.UpperCase),
                new CharacterRule(EnglishCharacterData.Special),
                new LengthRule (MIN_COUNT_CHARACTERS,MAX_COUNT_CHARACTERS));

        RuleResult result = validator.validate (new PasswordData(pass));
        return result.isValid ();

    }


}
