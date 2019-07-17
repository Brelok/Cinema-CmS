package com.github.brelok.controller;

import com.github.brelok.car.CarService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
@Slf4j // z lomboka
public class DashboardController {

    private CarService carService;

    @Autowired
    public DashboardController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String dashboard(Model model) {

        model.addAttribute("free", carService.countAvailableCar());
        model.addAttribute("count", carService.countAllCars());
        model.addAttribute("rented", carService.countRentCar());
        model.addAttribute("avarage", carService.avarageRating());
        model.addAttribute("avarageYear", carService.AvarageYear());
        model.addAttribute("avaragePrice",carService.avaragePrice());
        //spowoduje wyświetlenie na konsolę
        log.info("Info message");
        log.warn("warn");
        log.error("error message");
        return "dashboard";
    }
}
