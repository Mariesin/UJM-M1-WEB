package projet.poopngo;

//import java.sql.Date;

//import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import antlr.collections.List;

//import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;


@Controller
public class Mescontrollers {

    @Autowired
    private PersonRepository perso;

    @RequestMapping("/")
    public String accueil(){
        return "accueil";
    }

    @RequestMapping("/log_in")
    public String login(Model model){
        model.addAttribute("login", "");
        model.addAttribute("email", "");
        model.addAttribute("password", "");
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

    @RequestMapping(value = "/log", method = POST)
    public String log(@RequestParam String login,
        @RequestParam String email,
        @RequestParam String password
    ){
        List<Long> id = perso.findByLogin(login,email,password);
        if(id.get(0) != null){
            return "redirect:/";
        }
        return "redirect:/log_in";
    }
    @RequestMapping(value = "/session", method = POST)
    public String session(Person p){
        //Person p = new Person(name, firstname, birthday, login, address, phone, email, password);
        perso.save(p);
        return "redirect:/";
    }

    @RequestMapping("/map")
    public String map(){
        return "map";
    }

}