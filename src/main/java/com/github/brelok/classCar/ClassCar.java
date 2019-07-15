package com.github.brelok.classCar;

import com.github.brelok.configuration.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class ClassCar extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

//Arrays.asList("SUV", "kombi", "sedan", "compact", "coupe", "VAN");
}
