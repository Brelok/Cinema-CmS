package com.github.brelok.user;

import com.github.brelok.BaseEntity;
import com.github.brelok.order.Order;
import com.github.brelok.security.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please provide a firstname")
    private String firstName;

    @NotEmpty(message = "Please provide a lastname")
    private String lastName;

    @Email(message = "Please provide a valid mail")
    @NotEmpty(message = "Please provide a email")
    private String email;

    @Column(nullable = false, unique = true, length = 60)
    @NotEmpty(message = "Please provide a login")
    private String login;

    @Length(min = 8, message = "Your password must have at least 8 characters")
    private String password;

    private int enabled;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
