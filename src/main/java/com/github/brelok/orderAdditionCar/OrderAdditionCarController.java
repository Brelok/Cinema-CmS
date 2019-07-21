package com.github.brelok.orderAdditionCar;

import com.github.brelok.additionCar.AdditionCarService;
import com.github.brelok.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order/additions")
@Slf4j
public class OrderAdditionCarController {

    private OrderAdditionCarService orderAdditionCarService;
    private OrderService orderService;
    private AdditionCarService additionCarService;

    @Autowired
    public OrderAdditionCarController(OrderAdditionCarService orderAdditionCarService, OrderService orderService, AdditionCarService additionCarService) {
        this.orderAdditionCarService = orderAdditionCarService;
        this.orderService = orderService;
        this.additionCarService = additionCarService;
    }

    @GetMapping("/update")
    public String addAdditionsToOrder(Model model, @RequestParam Long id) {
        model.addAttribute("order", orderService.findOneDtoDisplay(id)); //DtoSave
        model.addAttribute("additions", additionCarService.findAll());//DtoDisplay

        return "order_edit_add";
    }

    @PostMapping("/update")
    public String addAdditionsToOrder(@RequestParam Long id,
                                      @RequestParam Long[] quantity,
                                      @RequestParam Long[] additionsId) {
        orderAdditionCarService.save(id, quantity, additionsId);
        return "redirect:/order";
    }


}
