package projet.poopngo;

public class map{
    private Person host;
    private String address;

    public map(String address, Person host) {
        this.address = address;
        this.host = host;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }

}