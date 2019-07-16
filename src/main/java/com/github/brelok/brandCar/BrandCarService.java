package com.github.brelok.brandCar;

import com.github.brelok.car.Car;
import com.github.brelok.car.CarDtoSave;
import com.github.brelok.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BrandCarService {

    private BrandCarRepository brandCarRepository;

    @Autowired
    public BrandCarService(BrandCarRepository brandCarRepository) {
        this.brandCarRepository = brandCarRepository;
    }

    public List findAll(){
        List<BrandCar> list = brandCarRepository.findAll();

        return list.stream()
                .map(BrandCarDto::new)
                .collect(Collectors.toList());
    }



}
