package com.github.brelok.additionCar;

import com.github.brelok.car.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AdditionCarDtoDisplay {

    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private List <String> carsName;

    public AdditionCarDtoDisplay(AdditionCar that){
        this.id = that.getId();
        this.name = that.getName();
        this.description = that.getDescription();
        this.quantity = that.getQuantity();
        this.carsName = that.getCars().stream()
                .map(Car::getAdditionsCars)
                .map(Object::toString)
                .collect(Collectors.toList());



    }
}
