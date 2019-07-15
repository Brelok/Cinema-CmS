package com.github.brelok.car;

import com.github.brelok.additionsCar.AdditionsCar;
import com.github.brelok.brandCar.BrandCar;
import com.github.brelok.classCar.ClassCar;
import com.github.brelok.BaseEntity;
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

    private String model;
    private int yearOfProduction;
    private double pricePerDay;
    private double rating;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "classCar_id")
    private ClassCar classCar;

    @ManyToMany
    @JoinTable(name = "car_additionsCar",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "additionalsCar_id"))
    private Set <AdditionsCar> additionsCars = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "car_equipmentsCar",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "equipmentsCar_id"))
    private Set<EquipmentsCar> equipmentsCars = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "brandCar_id")
    private BrandCar brandCar;


    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ClassCar getClassCar() {
        return classCar;
    }

    public void setClassCar(ClassCar classCar) {
        this.classCar = classCar;
    }

    public Set<AdditionsCar> getAdditionsCars() {
        return additionsCars;
    }

    public void setAdditionsCars(Set<AdditionsCar> additionsCars) {
        this.additionsCars = additionsCars;
    }

    public Set<EquipmentsCar> getEquipmentsCars() {
        return equipmentsCars;
    }

    public void setEquipmentsCars(Set<EquipmentsCar> equipmentsCars) {
        this.equipmentsCars = equipmentsCars;
    }

    public BrandCar getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(BrandCar brandCar) {
        this.brandCar = brandCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", yersOfProduction=" + yearOfProduction +
                ", pricePerDay=" + pricePerDay +
                ", rating=" + rating +
                ", status=" + status +
                ", classCar=" + classCar +
                ", additionsCars=" + additionsCars +
                ", equipmentsCars=" + equipmentsCars +
                ", brandCar=" + brandCar +
                '}';
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}
