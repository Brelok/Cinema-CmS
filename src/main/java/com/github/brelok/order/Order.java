package com.github.brelok.order;

import com.github.brelok.car.Car;
import com.github.brelok.configuration.BaseEntity;
import com.github.brelok.user.User;
import sun.jvm.hotspot.opto.HaltNode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalprice;
    private LocalDate startRent;
    private LocalDate endRent;

    @ManyToMany
    @JoinTable(name = "orders_car",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<Car> carSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
