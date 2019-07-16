package com.github.brelok.car;

import com.github.brelok.brandCar.BrandCarRepository;
import javafx.scene.transform.MatrixType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.tools.tree.DoubleExpression;

import java.util.List;
import java.util.Set;
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

    public Long countAvailableCar() {
        return carRepository.findAll().stream()
                .filter(car -> car.isStatus() == true).count();
    }

    public Long countAllCars(){
        return carRepository.findAll().stream().count();
    }

    public double avarageRating(){
        double sumRatings = 0;

        for (Car car : carRepository.findAll()){
            sumRatings += car.getRating();
        }

        return sumRatings / countAllCars();

    }

    public Long AvarageYear (){
        int sumYears = 0;

        for(Car car : carRepository.findAll()){
            sumYears += car.getYearOfProduction();
        }
        return sumYears / countAllCars();
    }

    public double avaragePrice(){
        double avaragePrice = 0;

        for (Car car : carRepository.findAll()){
            avaragePrice += car.getPricePerDay();
        }
        return avaragePrice / countAllCars();
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

    public Long countAllCarsOfThisBrand(long id){
        return carRepository.findAll().stream()
                .map(CarDtoSave::new)
                .filter(carDtoSave -> carDtoSave.getBrandId() == id).count();
    }

    public Set findAllBrandsCar (){
        return carRepository.findAll().stream()
                .map(CarDtoDisplay::new)
                .map(CarDtoDisplay::getBrandName)
                .collect(Collectors.toSet());
    }

    public List findAllCarByBrandName(String name){
        return carRepository.findAll().stream()
                .map(CarDtoDisplay::new)
                .filter(carDtoDisplay -> carDtoDisplay.getBrandName().equals(name))
                .collect(Collectors.toList());
    }

    public List findAllCarByClassNaem(String name){
        return carRepository.findAll().stream()
                .map(CarDtoDisplay::new)
                .filter(carDtoDisplay -> carDtoDisplay.getClassCarName().equals(name))
                .collect(Collectors.toList());
    }
}
