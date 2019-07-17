package com.github.brelok.additionCar;

import com.github.brelok.BaseEntity;
import com.github.brelok.car.Car;
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

    private Integer quantity;

    @ManyToMany(mappedBy = "additionsCars")
    private Set<Car> cars = new HashSet<>();

    @Override
    public String toString() {
        return "AdditionsCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", cars=" + cars +
                '}';
    }
}
