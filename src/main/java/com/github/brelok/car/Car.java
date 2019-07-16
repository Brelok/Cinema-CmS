package com.github.brelok.car;

import com.github.brelok.additionsCar.AdditionsCar;
import com.github.brelok.brandCar.BrandCar;
import com.github.brelok.classCar.ClassCar;
import com.github.brelok.BaseEntity;
import com.github.brelok.equipmentsCar.EquipmentsCar;
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

}
