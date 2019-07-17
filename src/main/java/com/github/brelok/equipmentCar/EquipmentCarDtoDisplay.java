package com.github.brelok.equipmentCar;

import com.github.brelok.car.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentCarDtoDisplay {

    private Long id;

    private String name;

    private String description;

    private List<String> carsName;

    public EquipmentCarDtoDisplay(EquipmentCar that){
        this.id = that.getId();
        this.name = that.getName();
        this.description = that.getDescription();
        this.carsName = that.getCars().stream()
                .map(Car::toString)
                .collect(Collectors.toList());

    }


}
