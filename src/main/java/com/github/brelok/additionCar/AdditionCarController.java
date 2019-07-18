package com.github.brelok.additionCar;

import com.github.brelok.car.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/addition")
public class AdditionCarController {

    private AdditionCarService additionsCarService;
    private CarService carService;

    public AdditionCarController(AdditionCarService additionsCarService, CarService carService) {
        this.additionsCarService = additionsCarService;
        this.carService = carService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("addition", additionsCarService.findAll());
        return "additions";
    }

    @GetMapping("/add")
    public String createAddition(Model model){
        model.addAttribute("add", new AdditionCarDtoSaveForm());
        return "addition_add";
    }

    @PostMapping("/add")
    public String createAddition (@ModelAttribute("additionCarDtoSave") @Valid AdditionCarDtoSaveForm additionsCarDtoSaveForm){
        additionsCarService.createAddition(additionsCarDtoSaveForm);
        return "redirect:/addition";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes){
        additionsCarService.delete(additionsCarService.findOne(id));
//        redirectAttributes.addFlashAttribute("message", "Succesed deleted");
        return "redirect:/addition";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam long id){
        model.addAttribute("add", additionsCarService.findOneDtoSaveForm(id));
        return "addition_edit";
    }

    @PostMapping ("/edit")
    public String edit(@ModelAttribute("additionDto") @Valid AdditionCarDtoSaveForm additionCarDtoSaveForm){
        additionsCarService.editAddition(additionCarDtoSaveForm);
        return "redirect:/addition";
    }

}
