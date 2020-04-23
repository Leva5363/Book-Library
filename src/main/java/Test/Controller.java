package Test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class Controller {
    @GetMapping ("/checkingPassword")
    public HttpStatus get (){
      return HttpStatus.OK;
    }

    @PostMapping ("/checkingPassword")
    public String post (@RequestBody String pas) {
        return Service.answer(pas);
    }
}
