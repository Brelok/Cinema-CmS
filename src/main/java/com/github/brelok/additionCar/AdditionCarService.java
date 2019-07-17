package com.github.brelok.additionCar;

import com.github.brelok.car.Car;
import com.github.brelok.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdditionCarService {

    private AdditionCarRepository additionCarRepository;
    private CarRepository carRepository;

    @Autowired
    public AdditionCarService(AdditionCarRepository additionsCarRepository, CarRepository carRepository) {
        this.additionCarRepository = additionsCarRepository;
        this.carRepository = carRepository;
    }

    public List findAll(){
        List <AdditionCar> list = additionCarRepository.findAll();

        return list.stream()
                .map(AdditionCarDtoDisplay::new)
                .collect(Collectors.toList());
    }

    public void createAddition (AdditionCarDtoSave additionCarDtoSave){
        AdditionCar additionCar = new AdditionCar();

       additionCar.setName(additionCarDtoSave.getName());
       additionCar.setDescription(additionCarDtoSave.getDescription());
       additionCar.setQuantity(additionCarDtoSave.getQuantity());
       additionCar.getCars().addAll(changeAdditionsCarDTOSaveToAdditionsCar(additionCarDtoSave.getCarsId()));

       additionCarRepository.save(additionCar);
    }

    public Set<Car> changeAdditionsCarDTOSaveToAdditionsCar(Long [] additions){
        List <Car> list = new ArrayList<>();

        for (Long along : additions){
            list.add(carRepository.findOne(along));
        }

        return new HashSet<>(list);
    }

}
