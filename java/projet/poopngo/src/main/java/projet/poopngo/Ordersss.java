package projet.poopngo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static javax.persistence.GenerationType.SEQUENCE;

//import java.util.Date;

import javax.persistence.ManyToOne;


//import java.sql.Date;

@Entity

public class Ordersss{


    private Long id;

    @ManyToOne
    private String client;
    
    @ManyToOne
    private String host;
    
    private String address;
    //private Time time;
    private String time;

    public Ordersss(){
        
    }
    public Ordersss(String client, String address, String host, String time) {
        this.client = client;
        this.address = address;
        this.host = host;
        this.time = time;

    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setClient(String client) {
        this.client = client;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClient() {
        return client;
    }

    public String getHost() {
        return host;
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