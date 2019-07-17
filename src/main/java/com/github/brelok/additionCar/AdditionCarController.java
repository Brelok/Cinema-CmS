package com.github.brelok.additionCar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("add", new AdditionCarDtoSaveForm());
        return "addition_add";
    }

    @PostMapping("/add")
    public String createAddition (@ModelAttribute("additionCarDtoSave") @Valid AdditionCarDtoSaveForm additionsCarDtoSaveForm){
        additionsCarService.createAddition(additionsCarDtoSaveForm);
        return "redirect:/addition";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id){
        additionsCarService.delete(id);
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
