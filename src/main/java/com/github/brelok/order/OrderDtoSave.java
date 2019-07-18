package com.github.brelok.order;

import com.github.brelok.additionCar.AdditionCar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class OrderDtoSave {

    private Long id;
    private String startRent;
    private String endRent;
    private Long carId;
    private Long userId;
    private Long[] additionsId;

    public OrderDtoSave(Order that) {
        this.id = that.getId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.startRent = that.getStartRent().format(formatter);
        this.endRent = that.getEndRent().format(formatter);
        this.carId = that.getCar().getId();
        this.userId = that.getUser().getId();
        this.additionsId = that.getAdditionsCars().stream()
                .map(AdditionCar::getId)
                .toArray(Long[]::new);
    }

}
