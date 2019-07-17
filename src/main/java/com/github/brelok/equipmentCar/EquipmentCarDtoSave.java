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
public class EquipmentCarDtoSave {

    private Long id;

    private String name;

    private String description;

    private Long[] carsName;

    public EquipmentCarDtoSave(EquipmentCar that){
        this.id = that.getId();
        this.name = that.getName();
        this.description = that.getDescription();
        this.carsName = that.getCars().stream()
                .map(Car::getId)
                .toArray(Long[]::new);

    }


}
