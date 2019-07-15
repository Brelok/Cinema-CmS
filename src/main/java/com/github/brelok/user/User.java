package com.github.brelok.user;

import com.github.brelok.configuration.BaseEntity;
import com.github.brelok.order.Order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

}
