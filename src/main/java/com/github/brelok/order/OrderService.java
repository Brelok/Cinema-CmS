package com.github.brelok.order;

import com.github.brelok.additionCar.AdditionCar;
import com.github.brelok.additionCar.AdditionCarRepository;
import com.github.brelok.car.CarRepository;
import com.github.brelok.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
@Slf4j
public class OrderService {

    private OrderRepository orderRepository;
    private CarRepository carRepository;
    private UserRepository userRepository;
    private AdditionCarRepository additionCarRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CarRepository carRepository, UserRepository userRepository, AdditionCarRepository additionCarRepository) {
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.additionCarRepository = additionCarRepository;
    }

    public List findAllDtoDisplay(){
        List<Order> list = orderRepository.findAll();

        return list.stream()
                .map(OrderDtoDisplay::new)
                .collect(Collectors.toList());
    }

    public List findAll (){
        return orderRepository.findAll();
    }

    public Order findOne(Long id){
        return orderRepository.getOne(id);
    }

    public OrderDtoSave findOneDtoSave(Long id){
        return new OrderDtoSave(orderRepository.getOne(id));
    }

    public Order setValuesOrderFromOrderDtoSave(Order order, OrderDtoSave orderDtoSave){
        order.setId(orderDtoSave.getId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        order.setStartRent(LocalDate.parse(orderDtoSave.getStartRent(), formatter));
        order.setEndRent(LocalDate.parse(orderDtoSave.getEndRent(),formatter));

        order.setCar(carRepository.getOne(orderDtoSave.getCarId()));
        order.setUser(userRepository.getOne(orderDtoSave.getUserId()));
log.info("orderDtoSave.getAdditionsId() {}",orderDtoSave.getAdditionsId());
log.info("changeAdditionsIdtoAdditions(orderDtoSave.getAdditionsId()) {}",changeAdditionsIdtoAdditions(orderDtoSave.getAdditionsId()));
        order.setAdditionsCars(changeAdditionsIdtoAdditions(orderDtoSave.getAdditionsId()));
log.info("order.getAdditionCar() {}", order.getAdditionsCars());
        long daysBetween = DAYS.between(order.getStartRent(), order.getEndRent());
        double pricePerDay = order.getCar().getPricePerDay();

        order.setTotalPrice(pricePerDay * daysBetween);

       return order;
    }

    public Set<AdditionCar> changeAdditionsIdtoAdditions(Long[] additionsIdArray){
        List<AdditionCar> list = new ArrayList<>();

        for (Long along : additionsIdArray){
            list.add(additionCarRepository.getOne(along));
        }
        return new HashSet<>(list);
    }

    public void createOrder (OrderDtoSave orderDtoSave){
        Order order = new Order();
        orderRepository.save(setValuesOrderFromOrderDtoSave(order,orderDtoSave));
    }

    public void deleteOrder (Order order){
        orderRepository.delete(order);
    }

    public void editOrder (OrderDtoSave orderDtoSave){
        Order existing = orderRepository.getOne(orderDtoSave.getId());
        orderRepository.save(setValuesOrderFromOrderDtoSave(existing,orderDtoSave));
    }
}
