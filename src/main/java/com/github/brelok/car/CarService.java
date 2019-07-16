package com.github.brelok.car;

import com.github.brelok.brandCar.BrandCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarService {


    private CarRepository carRepository;
    private BrandCarRepository brandCarRepository;

    @Autowired
    public CarService(CarRepository carRepository, BrandCarRepository brandCarRepository) {
        this.carRepository = carRepository;
        this.brandCarRepository = brandCarRepository;
    }

    public List findAll() {
        List<Car> carList = carRepository.findAll();

        return carList.stream()
                .map(CarDtoDisplay::new)
                .collect(Collectors.toList());
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }

    public Car findOne(Long id) {
        return carRepository.findOne(id);
    }

    public CarDtoSave findOneDto(Long id) {
        return new CarDtoSave(carRepository.findOne(id));
    }


    public void createCar(CarDtoSave carDtoSave) {
        Car car = new Car();

        carRepository.save(setValuesCarFromDtoValues(car, carDtoSave));
    }

    public void editCar(CarDtoSave carDtoSave) {
        Car existing = carRepository.findOne(carDtoSave.getId());

        carRepository.save(setValuesCarFromDtoValues(existing, carDtoSave));
    }

    private Car setValuesCarFromDtoValues(Car car, CarDtoSave carDtoSave) {

        car.setModel(carDtoSave.getModel());
        car.setPricePerDay(carDtoSave.getPricePerDay());
        car.setRating(carDtoSave.getRating());
        car.setStatus(carDtoSave.isStatus());
        car.setYearOfProduction(carDtoSave.getYearOfProduction());
        car.setBrandCar(brandCarRepository.findOne(carDtoSave.getBrandId()));
        return car;
    }
}
