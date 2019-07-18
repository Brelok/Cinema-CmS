package com.github.brelok.additionCar;

import com.github.brelok.car.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.wml.WMLStrongElement;

@Getter
@Setter
@NoArgsConstructor
public class AdditionCarDtoSave {

    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private double pricePerDay;

    public AdditionCarDtoSave(AdditionCar that){
        this.id = that.getId();
        this.name = that.getName();
        this.description = that.getDescription();
        this.quantity = that.getQuantity();
        this.pricePerDay = that.getPricePerDay();
    }
}
