package com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    @Column
    private String username;
    @Column
    private String password;
    @Column(name = "isadmin")
    private boolean admin;
}
