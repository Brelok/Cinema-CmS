package com.github.brelok.classCar;

import com.github.brelok.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequestMapping("/class")
public class ClassCarController {

    private CarService carService;
    private ClassCarService classCarService;

    @Autowired
    public ClassCarController(CarService carService, ClassCarService classCarService) {
        this.carService = carService;
        this.classCarService = classCarService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("classesCar", classCarService.findAll());
        return "classes";
    }

    @GetMapping("/car")
    public String allCarsofClass(Model model, @RequestParam String name){
        model.addAttribute("class", carService.findAllCarByClassNaem(name));
        return "car_classes";
    }
}
