package com.github.brelok.classCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClassCarService {

    private ClassCarRepository classCarRepository;

    @Autowired
    public ClassCarService(ClassCarRepository classCarRepository) {
        this.classCarRepository = classCarRepository;
    }

    public List findAll() {

        List<ClassCar> classCar = classCarRepository.findAll();

        return classCar.stream()
                .map(ClassCarDto::new)
                .collect(Collectors.toList());
    }
}
