package com.github.brelok.classCar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClassCarDto {
    
    private Long id;
    private String type;
    
    public ClassCarDto(ClassCar that){
        this.id = that.getId();
        this.type = that.getType();

    }

    @Override
    public String toString() {
        return type;
    }
}
