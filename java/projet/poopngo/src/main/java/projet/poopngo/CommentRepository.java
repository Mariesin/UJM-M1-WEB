package projet.poopngo;

import org.springframework.data.jpa.repository.JpaRepository;

//long:id primary key
public interface  CommentRepository extends JpaRepository<Comment, Long> {

}
