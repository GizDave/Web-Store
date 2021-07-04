package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerid;
    @Column
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
}
