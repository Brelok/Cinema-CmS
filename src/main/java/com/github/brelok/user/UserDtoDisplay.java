package com.github.brelok.user;

import com.github.brelok.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoDisplay {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    private List<String> ordersName;

    public UserDtoDisplay (User that){
        this.id = that.getId();
        this.firstName = that.getFirstName();
        this.lastName = that.getLastName();
        this.email = that.getEmail();
        this.login = that.getLogin();
        this.password = that.getPassword();
        this.ordersName = that.getOrders().stream()
                .map(Order::toString)
                .collect(Collectors.toList());


    }

}
