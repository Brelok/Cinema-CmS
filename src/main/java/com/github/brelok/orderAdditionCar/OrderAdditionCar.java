package com.github.brelok.orderAdditionCar;

import com.github.brelok.additionCar.AdditionCar;
import com.github.brelok.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderAdditionCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "additionalCar_id")
    private AdditionCar additionCar;

    private Integer additionQuantity;


}
