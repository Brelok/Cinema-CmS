package com.github.brelok.car;

import com.github.brelok.brandCar.BrandCarRepository;
import com.github.brelok.brandCar.BrandCarService;
import com.github.brelok.classCar.ClassCarRepository;
import com.github.brelok.classCar.ClassCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarViewController {

    private CarService carService;
    private BrandCarService brandCarService;
    private ClassCarService classCarService;

    @Autowired
    public CarViewController(CarService carService, BrandCarRepository brandCarRepository, BrandCarService brandCarService, CarRepository carRepository, ClassCarRepository classCarRepository, ClassCarService classCarService) {
        this.carService = carService;
        this.brandCarService = brandCarService;
        this.classCarService = classCarService;
    }
    @ModelAttribute("brands")
    public List getAllBrand (){
        return brandCarService.findAll();
    }

    @ModelAttribute("classCar")
    public List getAllClass(){
        return classCarService.findAll();
    }

    @GetMapping("showAll")
    public String showAll(Model model){
       model.addAttribute("cars", carService.findAll());
       return "cars";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("car", new CarDtoSave());
        return "cars_add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("carDto") @Valid CarDtoSave carDto){
        carService.createCar(carDto);
        return "cars";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id){
        model.addAttribute("car", carService.findOneDto(id));
        return "car_edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("carDto") CarDtoSave carDto){
        carService.editCar(carDto);
        return "cars_old";
    }

}
