package com.github.brelok.car;

import com.github.brelok.additionCar.AdditionCar;
import com.github.brelok.equipmentCar.EquipmentCar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CarDtoDisplay {

    private Long id;

    @NotNull
    private String model;

    @NotNull
    private int yearOfProduction;

    @NotNull
    private double pricePerDay;

    private double rating;

    @NotNull
    private boolean status;

    @NotNull
    private String classCarName;

    private List<String> equipmentsCar;
    private String brandName;


    public CarDtoDisplay(Car that) {
        this.id = that.getId();
        this.model = that.getModel();
        this.yearOfProduction = that.getYearOfProduction();
        this.pricePerDay = that.getPricePerDay();
        this.rating = that.getRating();
        this.status = that.isStatus();
        this.classCarName = that.getClassCar().toString();
        this.equipmentsCar = that.getEquipmentsCars().stream()
                .map(EquipmentCar::getName).collect(Collectors.toList());
        this.brandName = that.getBrandCar().toString();

    }

}
