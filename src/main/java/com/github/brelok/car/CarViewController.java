package com.github.brelok.car;

import com.github.brelok.brandCar.BrandCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;

@Controller
@RequestMapping("/car")
public class CarViewController {

    private CarService carService;
    private BrandCarRepository brandCarRepository;
//    private Validator validator;


    @Autowired
    public CarViewController(CarService carService, BrandCarRepository brandCarRepository) {
        this.carService = carService;
        this.brandCarRepository = brandCarRepository;
    }

    @GetMapping("showAll")
    public String showAll(Model model){
       model.addAttribute("cars", carService.findAll());
       return "cars";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("car", new CarDto());
        return "car_add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("carDto") CarDto carDto){
        carService.createCar(carDto);
        return "cars";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id){
        model.addAttribute("car", carService.findOneDto(id));
        return "car_edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("carDto") CarDto carDto){
        carService.editCar(carDto);
        return "cars";
    }
}
