package com.github.brelok.user;

import com.github.brelok.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoSave {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    public UserDtoSave(User that){
        this.id = that.getId();
        this.firstName = that.getFirstName();
        this.lastName = that.getLastName();
        this.email = that.getEmail();
        this.login = that.getLogin();
        this.password = that.getPassword();

    }
}
