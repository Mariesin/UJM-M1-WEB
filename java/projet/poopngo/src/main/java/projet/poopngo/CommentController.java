package projet.poopngo;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
//get all persons
	    @GetMapping("/persons")
	    private List<Person> getAllPersons() {
	        return personService.getAllPersons();
	        
	    }
	}
	
	
	@GetMapping(path = "/comment")
    public String home(ModelMap model){
		List<Person> list = (List<Person>) personeService.findAll();
		model.addAttribute("persones",list);
        return "comment";
    }
//add comment 
	@Transactional
	@PostMapping(path = "/add/comment")
    public String addComment(@RequestParam String text,@RequestParam Long target){
		Person p =personeService.findById(target).get();
		String name =p.getFirstname()+" "+ p.getName();
		Comment c = new Comment();
		c.setId_source(1L);
		c.setId_target(target);
		c.setText(text);
		c.setName_target(name);
		service.save(c);
		
        return "comment";
    }
}

