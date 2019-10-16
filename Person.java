package projet.popngo;

public class Person {

  private String name; 
  private String firstname; 
  private String address;
  private String email;

  private String state;


    public Person(String name, String firstname, String address, String email, String state) {
        this.name = name;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
        this.state = state;
}

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

}