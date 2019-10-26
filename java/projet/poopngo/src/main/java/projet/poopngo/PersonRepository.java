package projet.poopngo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends CrudRepository<Person, Long>{
    @Query(value = "SELECT CUST_ID FROM PERSON WHERE LOGIN = :login AND EMAIL = :email AND PASSWORD = :password",nativeQuery = true) 
    List<Long> findByLogin(
        @Param("login") String login,
        @Param("email") String email,
        @Param("password") String password);
    /*@Query("select CUST_ID FROM PERSON p WHERE  p.EMAIL = "+email+" AND p.LOGIN = "+login+" AND p.PASSWORD = "+password+"")
        List<Long> id;*/
}