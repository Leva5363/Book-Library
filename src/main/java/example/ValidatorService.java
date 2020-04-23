package example;

import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

    public static String checkPassword (String string) {
        if (MyPasswordValidator.checkingPass (string)) {
            return "The password is correct";
        } else {
            return "The password is incorrect";
        }
    }
}