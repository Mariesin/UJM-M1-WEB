package projet.poopngo;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

	@Autowired
	private CommentRepository service;
	@Autowired
	private PersonRepository personeService;
	
	@GetMapping(path = "/comment")
    public String home(){
		//list of target
//		List<Person> list = (List<Person>) personeService.findAll();
        return "comment";
    }
//add comment 
	@PostMapping(path = "/add/comment")
    public String addComment(@RequestParam String text,@RequestParam Long target){
		//target id : id de persone a commenter
		Optional<Person> p = personeService.findById(target);
		Person t = p.get(); 
		Comment m= new Comment();
		m.setTarget(t);
		m.setText(text);
		//m.setSource();
		service.save(m);
        return "comment";
    }
}

