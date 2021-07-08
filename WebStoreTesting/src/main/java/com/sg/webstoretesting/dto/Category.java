package com.sg.webstoretesting.dto;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private int categoryid;
    @Column(name = "name")
    private String name;
}
