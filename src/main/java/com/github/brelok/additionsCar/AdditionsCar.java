package com.github.brelok.additionsCar;

import com.github.brelok.BaseEntity;
import com.github.brelok.car.Car;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AdditionsCar extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1500)
    private String description;

    @ManyToMany(mappedBy = "additionsCars")
    private Set<Car> cars = new HashSet<>();


    public AdditionsCar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
