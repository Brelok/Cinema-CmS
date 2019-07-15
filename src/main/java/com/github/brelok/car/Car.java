package com.github.brelok.car;

import com.github.brelok.additionsCar.AdditionsCar;
import com.github.brelok.classCar.ClassCar;
import com.github.brelok.configuration.BaseEntity;
import com.github.brelok.equipmentsCar.EquipmentsCar;
import com.github.brelok.order.Order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private Integer yersOfProduction;
    private Double pricePerDay;
    private Double rating;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "classCar_id")
    private ClassCar classCar;

    @ManyToOne
    @JoinColumn(name = "additionsCar_id")
    private AdditionsCar additionsCar;

    @ManyToOne
    @JoinColumn(name = "equipmentsCar_id")
    private EquipmentsCar equipmentsCar;

    @ManyToMany(mappedBy = "carSet")
    private Set<Order> orders = new HashSet<>();




}
