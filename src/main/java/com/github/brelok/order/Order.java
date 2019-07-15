package com.github.brelok.order;

import com.github.brelok.car.Car;
import com.github.brelok.BaseEntity;
import com.github.brelok.user.User;

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

    @ManyToOne
    private Car car;

    @ManyToOne
    private User user;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public LocalDate getStartRent() {
        return startRent;
    }

    public LocalDate getEndRent() {
        return endRent;
    }

    public Car getCar() {
        return car;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalprice=" + totalprice +
                ", startRent=" + startRent +
                ", endRent=" + endRent +
                ", car=" + car +
                ", user=" + user +
                '}';
    }
}
