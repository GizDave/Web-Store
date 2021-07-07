package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerid;
    @Column(insertable = false, updatable = false)
    private int userid;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String phone;
    @Column
    private String email;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
    @OneToMany(mappedBy = "customer")
    private Set<CustomerAddressBridge> customerAddressBridgeSet;
}
