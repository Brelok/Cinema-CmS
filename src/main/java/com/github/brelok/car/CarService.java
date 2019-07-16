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

    public List findAll(){
        List<Car> carList = carRepository.findAll();

        return carList.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

    public void delete (Car car) {
        carRepository.delete(car);
    }

    public Car findOne(Long id){
        return carRepository.findOne(id);
    }

    public CarDto findOneDto(Long id) {
        return new CarDto(carRepository.findOne(id));
    }

    public void createCar(CarDto carDto){
        Car car = new Car();

        carRepository.save(setValuesCarFromDtoValues(car, carDto));
    }

    public void editCar(CarDto carDto){
        Car existing = carRepository.findOne(carDto.getId());

        carRepository.save(setValuesCarFromDtoValues(existing, carDto));
    }

    private Car setValuesCarFromDtoValues (Car car, CarDto carDto){

        car.setModel(carDto.getModel());
        car.setPricePerDay(carDto.getPricePerDay());
        car.setRating(carDto.getRating());
        car.setStatus(carDto.isStatus());
        car.setYearOfProduction(carDto.getYearOfProduction());
        car.setBrandCar(brandCarRepository.findOne(carDto.getId()));

        return car;
    }
}
