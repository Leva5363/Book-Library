package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App
{

    public static String password;
    public static void main( String[] args ) throws IOException {
        if(args.length>0) password=args[0];
        else {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            try {
                password=br.readLine();
            } catch (IOException e) {
                System.out.println("Password wasn't entered!");
                br.close();
            }
            br.close();
        }



        checkingPass(password);

        System.out.println("Changes for git");
        System.out.println("Second sout for git");
    }

    public static void checkingPass(String pass){
        String patternString="(?=.*[0-9])(?=.*[!@#$%^&*_-])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{4,8}";
        Pattern pattern=Pattern.compile(patternString);
        Matcher matcher=pattern.matcher(pass);
        if(matcher.matches()) System.out.println("The password accessed");
        else System.out.println("The password is incorrect!");

    }

}
