package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private int customerid;
    @Column(name = "userid", insertable = false, updatable = false)
    private int userid;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
}
