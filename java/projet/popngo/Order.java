package projet.popngo;

public class Order{
    private Person client;
    private Person host;
    private String address;

    public Order(Person client, String address, Person host) {
        this.client = client;
        this.address = address;
        this.host = host;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
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