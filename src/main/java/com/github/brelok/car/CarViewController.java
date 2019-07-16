package com.github.brelok.car;

import com.github.brelok.brandCar.BrandCarRepository;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarViewController {

    private CarService carService;
    private BrandCarRepository brandCarRepository;

    @Autowired
    public CarViewController(CarService carService, BrandCarRepository brandCarRepository) {
        this.carService = carService;
        this.brandCarRepository = brandCarRepository;
    }
    @ModelAttribute("brands")
    public List getAllBrand (){
        return brandCarRepository.findAll();
    }

    @GetMapping("showAll")
    public String showAll(Model model){
       model.addAttribute("cars", carService.findAll());
       return "btables";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("car", new CarDto());
        return "car_add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("carDto") @Valid CarDto carDto){
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
