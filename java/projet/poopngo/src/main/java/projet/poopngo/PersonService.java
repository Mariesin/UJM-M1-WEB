package projet.poopngo;

//import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import java.util.Optional;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;*/

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PersonService implements UserDetailsService {


    @Inject
    PersonRepository repo;

    public final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> opt = repo.findById(username);
        if (opt.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        Person u = opt.get();
        return new org.springframework.security.core.userdetails.User(u.userName, u.derivedPassword, u.getRoles());
    }

    public void saveUserComputingDerivedPassword(Person u, String rawPassword) {
        setComputingDerivedPassword(u, rawPassword);
        repo.save(u);
    }

    public void setComputingDerivedPassword(Person u, String rawPassword) {
        String codedPassword = encoder.encode(rawPassword);
        u.setDerivedPassword(codedPassword);
    }

    public void makeUserAdmin(String username) {
        Person u = repo.findById(username).orElse(null);
        u.getRoles().add(PersonRole.ADMIN);
        repo.save(u);
    }

    public List<Person> listAllUsers() {
        return repo.findAllByOrderByUserName();
    }
    
}


/*@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
	    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<Person>();
        personRepository.findAll().forEach(person -> persons.add(person));
        return persons;
    }

	public Person getPersonById(int id) {
        return personRepository.findById((long) id).get();
    }

    public void saveOrUpdate(Person person) {
        personRepository.save(person);
    }

}*/
