package com.github.brelok.equipmentCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipment")
public class EquipmentCarController {

    private EquipmentCarService equipmentCarService;

    @Autowired
    public EquipmentCarController(EquipmentCarService equipmentCarService) {
        this.equipmentCarService = equipmentCarService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("equipments", equipmentCarService.findAll());
        return "equipments";
    }
}
