package projet.poopngo;


import org.springframework.data.repository.CrudRepository;

//long:id primary key
public interface  CommentRepository extends CrudRepository<Comment, Long> {

	
}
