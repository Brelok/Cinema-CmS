package com.github.brelok.additionCar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/addition")
public class AdditionCarController {

    private AdditionCarService additionsCarService;

    public AdditionCarController(AdditionCarService additionsCarService) {
        this.additionsCarService = additionsCarService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("addition", additionsCarService.findAll());
        return "additions";
    }

    @GetMapping("/add")
    public String createAddition(Model model){
        model.addAttribute("add", new AdditionCarDtoSave());
        return "addition_add";
    }

    @PostMapping("/add")
    public String createAddition (@ModelAttribute("additionCarDtoSave") @Valid AdditionCarDtoSave additionsCarDtoSave){
        additionsCarService.createAddition(additionsCarDtoSave);
        return "redirect:/addition";
    }
}
