package com.github.brelok.car;

import com.github.brelok.additionsCar.AdditionsCar;
import com.github.brelok.equipmentsCar.EquipmentsCar;
import sun.tools.asm.CatchData;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class CarDto {

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

    private List<String> additionsCar;
    private List<String> equipmentsCar;
//    private Long brandId;
    private String brandCarName;


    public CarDto() {
    }

    public CarDto(Car that) {
        this.id = that.getId();
        this.model = that.getModel();
        this.yearOfProduction = that.getYearOfProduction();
        this.pricePerDay = that.getPricePerDay();
        this.rating = that.getRating();
        this.status = that.isStatus();
        this.classCarName = that.getClassCar().toString();
        this.additionsCar = that.getAdditionsCars().stream()
                .map(AdditionsCar::getName).collect(Collectors.toList());
        this.equipmentsCar = that.getEquipmentsCars().stream()
                .map(EquipmentsCar::getName).collect(Collectors.toList());
        this.brandCarName = that.getBrandCar().toString();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getClassCarName() {
        return classCarName;
    }

    public void setClassCarName(String classCarName) {
        this.classCarName = classCarName;
    }

    public List<String> getAdditionsCar() {
        return additionsCar;
    }

    public void setAdditionsCar(List<String> additionsCar) {
        this.additionsCar = additionsCar;
    }

    public List<String> getEquipmentsCar() {
        return equipmentsCar;
    }

    public void setEquipmentsCar(List<String> equipmentsCar) {
        this.equipmentsCar = equipmentsCar;
    }

    public String getBrandCarName() {
        return brandCarName;
    }

    public void setBrandCarName(String brandCarName) {
        this.brandCarName = brandCarName;
    }
}
