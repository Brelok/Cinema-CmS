package com.github.brelok.order;

import ch.qos.logback.classic.util.LoggerNameUtil;
import com.github.brelok.additionCar.AdditionCarService;
import com.github.brelok.car.CarService;
import com.github.brelok.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    private OrderService orderService;
    private CarService carService;
    private AdditionCarService additionCarService;
    private UserService userService;

    @Autowired
    public OrderController(OrderService orderService, CarService carService, AdditionCarService additionCarService, UserService userService) {
        this.orderService = orderService;
        this.carService = carService;
        this.additionCarService = additionCarService;
        this.userService = userService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("orders", orderService.findAllDtoDisplay());
//        model.addAttribute("addInOrder", additionCarService.findAllAdditionsCarInThisOrOrderBy());
        return "orders";
    }

    @ModelAttribute("cars")
    public List getAllCarsDtoDisplay() {
        return carService.findAll();
    }

    @ModelAttribute("users")
    public List getAllUsersDtoDisplay() {
        return userService.findAllDtoDisplay();
    }

    @ModelAttribute("additions")
    public List getAllAdditionsDto() {
        return additionCarService.findAll();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("order", new OrderDtoSave());
//        model.addAttribute("standardDate", new Date());
//        model.addAttribute("localDateTime", LocalDateTime.now());
//        model.addAttribute("localDate", LocalDate.now());
//        model.addAttribute("timestamp", Instant.now());
        return "order_add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "orderDto") @Valid OrderDtoSave orderDtoSave) {
        log.error("startRent ", orderDtoSave.getStartRent());
        orderService.createOrder(orderDtoSave);
        return "redirect:/order";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        model.addAttribute("order", orderService.findOneDtoSave(id));
        return "order_edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("orderDto") @Valid OrderDtoSave orderDtoSave) {
        orderService.editOrder(orderDtoSave);
        return "redirect:/order";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        orderService.deleteOrder(orderService.findOne(id));
        return "redirect:/order";
    }

    @GetMapping("/edit_additions")
    public String editAdditions(Model model, @RequestParam Long id) {
        model.addAttribute("order", orderService.findOneDtoSave(id));
        return "order_edit_add";
    }

    @PostMapping("/edit/additions")
    public String editAdditions(@ModelAttribute("orderDto") @Valid OrderDtoSave orderDtoSave,
                                @RequestParam Long[] ids,
                                @RequestParam Long[] quantity) {
        log.info("ids {}", Arrays.toString(ids));
        log.info("totalQuantity {}", Arrays.toString(quantity));
        log.info("id moje {} ", orderDtoSave.getId());

//        orderService.editOrder(orderDtoSave);
        return "redirect:/order";
    }

}
