package Test;

@org.springframework.stereotype.Service
public class Service {

    public static String answer (String string){
        if(MyPasswordValidator.checkingPass (string)){
            return "The password is correct";
        } else {
            return "The password is incorrect";
        }
    }
}
