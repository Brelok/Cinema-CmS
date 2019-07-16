package com.github.brelok.brandCar;

import com.github.brelok.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/brand")
public class BrandCarController {

    private BrandCarService brandCarService;
    private CarService carService;

    @Autowired
    public BrandCarController(BrandCarService brandCarService, CarService carService) {
        this.brandCarService = brandCarService;
        this.carService = carService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("brands", carService.findAllBrandsCar());
        return "brands";
    }

    @GetMapping("/car")
    public String allCarsOfBrand(Model model, @RequestParam String name){
        model.addAttribute("brand", carService.findAllCarByBrandName(name));
        return "car_brand";
    }
}
