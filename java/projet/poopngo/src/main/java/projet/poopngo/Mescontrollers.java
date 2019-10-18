package projet.poopngo;

//import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Mescontrollers {
   //private PersonRepository perso;

    @RequestMapping("/")
    public String accueil(){
        return "accueil";
    }

    @RequestMapping("/log_in")
    public String login(){
        return "log_in";
    }

    @RequestMapping("/sign_up")
    public String signup(){
        return "sign_up";
    }

    @RequestMapping("/accueil")
    public String home(){
        return "accueil";
    }

   /* @RequestMapping("/session")
    public String session(
        @RequestParam String name,
        @RequestParam String firstname,
        @RequestParam Date birthday,
        @RequestParam String login,
        @RequestParam String address,
        @RequestParam Integer phone,
        @RequestParam String email,
        @RequestParam String password
    ){
        Person p = new Person(name, firstname, birthday, login, address, phone, email, password);
        perso.save(p);
        return "session";
    }*/

}