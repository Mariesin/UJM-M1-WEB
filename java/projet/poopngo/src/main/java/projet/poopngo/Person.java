package projet.poopngo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Id;

@Entity
public class Person {

  private Long id;
  private String name; 
  private String firstname;
  private Date birthday; 
  private String login;
  private String address;
  private Integer phone;
  private String email;
  private String password;
  private String state;




     public void afficher() {
      System.out.println("Name : "+name+" firstname : "+firstname+" address : "+address+" email : "+email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Person(){
        
    }
    public Person(String name, String firstname, Date birthday, String login, String address, Integer phone,
            String email, String password) {
        this.name = name;
        this.firstname = firstname;
        this.birthday = birthday;
        this.login = login;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
    @Column(name="CUST_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}