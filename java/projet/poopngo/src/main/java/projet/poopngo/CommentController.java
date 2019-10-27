package projet.poopngo;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CommentController {

	@Autowired
	private CommentRepository service;
	@Autowired
	private PersonRepository personeService;
	
	@RestController
	public class PersonController {

	    @Autowired
	    PersonService personService;

	    @GetMapping("/persons")
	    private List<Person> getAllPersons() {
	        return personService.getAllPersons();
	        
	    }
	}
	
	
	@GetMapping(path = "/comment")
    public String home(){
		//list of person
		//List<Person> list = (List<Person>) personeService.findAll();
        return "comment";
    }
//add comment 
	@PostMapping(path = "/add/comment")
    public String addComment(@RequestParam String text,@RequestParam Long target){
		//target id : id de persone a commenter liste derou
		Optional<Person> p = personeService.findById(target);
		//recuperer la personne 
		Person t = p.get(); 
		Comment m= new Comment();
		m.setTarget(t);
		m.setText(text);
		//m.setSource();
		//m.seTarget();

		service.save(m);
        return "comment";
    }
}

