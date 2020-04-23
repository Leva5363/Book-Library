package example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @GetMapping ("/checkingPassword")
    public HttpStatus ViewStatus (){
      return HttpStatus.OK;
    }

    @PostMapping ("/checkingPassword")
    public String post (@RequestBody String pas) {
        return ValidatorService.checkPassword(pas);
    }
}
