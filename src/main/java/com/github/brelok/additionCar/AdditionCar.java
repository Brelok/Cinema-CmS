package com.github.brelok.additionCar;

import com.github.brelok.BaseEntity;
import com.github.brelok.order.Order;
import com.github.brelok.orderAdditionCar.OrderAdditionCar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AdditionCar extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1500)
    private String description;

    private Integer totalQuantity;
    private double pricePerDay;

    @OneToMany(mappedBy = "additionCar")
    private Set<OrderAdditionCar> orderAdditionCars;

    @Override
    public String toString() {
        return name;
    }
}
