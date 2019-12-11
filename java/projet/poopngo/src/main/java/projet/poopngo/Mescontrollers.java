package projet.poopngo;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.inject.Inject;

//import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class Mescontrollers {
    @Inject
    PersonService personService;


    @Autowired
    private OrderRepository order;
    @Autowired
    private PersonRepository perso;


    @RequestMapping("/")
    public String homepage(){
        return "homepage";
    }

    @RequestMapping("/order")
    public String order(Authentication auth,Model model){
        List<Ordersss> ord = order.findByidH(auth.getName());
        List<Ordersss> myord = order.findByidC(auth.getName());
        
        model.addAttribute("lorder",ord);
        model.addAttribute("state",perso.state(auth.getName()));
        model.addAttribute("myOrder",myord);
        model.addAttribute("newO", new Ordersss());
        return "order";
    }

    @RequestMapping(value = "/addOrder", method = POST)
    public String addOrder(Ordersss o,Authentication auth,Model model){
        o.setClient(auth.getName());
        o.setAddress(perso.address(o.getHost()));

        if(perso.state(o.getHost()) == "open"){
            order.save(o);
        }
        return "redirect:/order";
    }


    @RequestMapping(value = "/newState")
    public String newState(Authentication auth,Model model){
        
        Person p = perso.person(auth.getName());
        //p.setUserName(auth.getName());
        if(p.getState() == "open"){
            //perso.newsta("close", auth.getName());
            p.setState("close");
        }
        else{
            //perso.newsta("open", auth.getName());
            p.setState("open");
        }

        perso.save(p);
        return "redirect:/order";
    }

    @RequestMapping("/sign_up")
    public String signup(Model model){
        model.addAttribute("pers", new Person());
        return "sign_up";
    }

    @RequestMapping("/homepage")
    public String home(){
        return "homepage";
    }
    
    @RequestMapping(value = "/session", method = POST)
    public String session(Person p){
        //Person p = new Person(name, firstname, birthday, login, address, phone, email, password);
        p.getRoles().add(PersonRole.USER);
        personService.setComputingDerivedPassword(p, p.derivedPassword);
        p.setState("close");
        perso.save(p);
        return "redirect:/";
    }

}