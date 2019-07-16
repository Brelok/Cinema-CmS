package com.github.brelok.brandCar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BrandCarDto {

    private Long id;
    private String brand;


    public BrandCarDto (BrandCar that){
        this.id = that.getId();
        this.brand = that.getBrand();

    }
}
