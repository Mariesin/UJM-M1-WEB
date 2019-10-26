package projet.poopngo;

//import java.sql.Date;

//import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class Mescontrollers {

    @Autowired
    private PersonRepository perso;

    @RequestMapping("/")
    public String accueil(){
        return "accueil";
    }

    @RequestMapping("/log_in")
    public String login(){
        return "log_in";
    }

    @RequestMapping("/sign_up")
    public String signup(Model model){
        model.addAttribute("pers", new Person());
        return "sign_up";
    }

    @RequestMapping("/accueil")
    public String home(){
        return "accueil";
    }

    @RequestMapping(value = "/session", method = POST)
    public String session( Person p
        /*@RequestParam String name,
        @RequestParam String firstname,
        @RequestParam Date birthday,
        @RequestParam String login,
        @RequestParam String address,
        @RequestParam Integer phone,
        @RequestParam String email,
        @RequestParam String password*/
    ){
        //Person p = new Person(name, firstname, birthday, login, address, phone, email, password);
        perso.save(p);
        return "redirect:/";
    }

}