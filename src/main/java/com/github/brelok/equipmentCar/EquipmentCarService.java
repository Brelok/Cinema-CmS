package com.github.brelok.equipmentCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EquipmentCarService {

    private EquipmentCarRepository equipmentCarRepository;

    @Autowired
    public EquipmentCarService(EquipmentCarRepository equipmentCarRepository) {
        this.equipmentCarRepository = equipmentCarRepository;
    }

    public List findAll(){
        List<EquipmentCar> list = equipmentCarRepository.findAll();

        return list.stream()
                .map(EquipmentCarDtoDisplay::new)
                .collect(Collectors.toList());
    }
}
