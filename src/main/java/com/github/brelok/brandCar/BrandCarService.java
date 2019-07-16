package com.github.brelok.brandCar;

import com.github.brelok.car.CarDtoSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandCarService {

    private BrandCarRepository brandCarRepository;

    @Autowired
    public BrandCarService(BrandCarRepository brandCarRepository) {
        this.brandCarRepository = brandCarRepository;
    }

    public List findAll(){
        return brandCarRepository.findAll();
    }

    public BrandCar findOneByBrandCarDto(CarDtoSave carDto){
        return brandCarRepository.findOne(carDto.getBrandId());
    }
}
