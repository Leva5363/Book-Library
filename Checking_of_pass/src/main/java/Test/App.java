package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App{
        public static void main( String[] args ){
        String password="";
        if(args.length > 0) {
            password = args[0];
        }
        else {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            try {
                password = br.readLine();
                br.close();
            } catch (IOException e) {
                System.out.println("Password wasn't entered!");

            }

        }

        if(MyPasswordValidator.checkingPass(password)){
            System.out.println("The password accepted");
        }else{
            System.out.println("Wrong password");
        }


    }




}
