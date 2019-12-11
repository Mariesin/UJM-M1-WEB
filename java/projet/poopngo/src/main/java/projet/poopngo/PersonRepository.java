package projet.poopngo;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * UserRepository
 */
//import org.springframework.jdbc.object.UpdatableSqlQuery;
public interface PersonRepository extends CrudRepository<Person, String> {

    public List<Person> findAllByOrderByUserName();
    

    @Query(value = "SELECT STATE FROM PERSON WHERE USER_NAME = :id",nativeQuery = true) 
    String state(@Param("id") String id);   
    
    @Query(value = "SELECT ADDRESS FROM PERSON WHERE USER_NAME = :id",nativeQuery = true) 
    String address(@Param("id") String id);

    @Query(value = "SELECT * FROM PERSON WHERE USER_NAME = :id",nativeQuery = true) 
    Person person(@Param("id") String id); 
    
}

