package com.github.brelok.order;

import com.github.brelok.car.Car;
import com.github.brelok.BaseEntity;
import com.github.brelok.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalPrice;
    private LocalDate startRent;

    private LocalDate endRent;

    @ManyToOne
    private Car car;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalprice=" + totalPrice +
                ", startRent=" + startRent +
                ", endRent=" + endRent +
                ", car=" + car +
                ", user=" + user +
                '}';
    }
}
