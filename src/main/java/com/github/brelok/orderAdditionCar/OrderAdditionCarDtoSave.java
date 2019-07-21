package com.github.brelok.orderAdditionCar;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
public class OrderAdditionCarDtoSave {

    private Long id;

    private Long orderId;
    private Long additionCarId;
    private Integer additionQuantity;

    public OrderAdditionCarDtoSave (OrderAdditionCar that){
        this.id = that.getId();
        this.orderId = that.getOrder().getId();
        this.additionCarId = that.getAdditionCar().getId();
        this.additionQuantity = that.getAdditionQuantity();

    }
}
