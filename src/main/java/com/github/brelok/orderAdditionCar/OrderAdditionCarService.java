package com.github.brelok.orderAdditionCar;

import com.github.brelok.additionCar.AdditionCar;
import com.github.brelok.order.Order;
import com.github.brelok.order.OrderDtoSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
public class OrderAdditionCarService {

    private OrderAdditionCarRepository orderAdditionCarRepository;

    @Autowired
    public OrderAdditionCarService(OrderAdditionCarRepository orderAdditionCarRepository) {
        this.orderAdditionCarRepository = orderAdditionCarRepository;
    }

//      public Order setValuesOrderFromOrderDtoSave(Order order, OrderDtoSave orderDtoSave) {
//        order.setId(orderDtoSave.getId());
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        order.setStartRent(LocalDate.parse(orderDtoSave.getStartRent(), formatter));
//        order.setEndRent(LocalDate.parse(orderDtoSave.getEndRent(), formatter));
//
//        order.setCar(carRepository.getOne(orderDtoSave.getCarId()));
//        order.setUser(userRepository.getOne(orderDtoSave.getUserId()));
//        order.setOrderAdditionCars(changeAdditionsIdtoAdditions(orderDtoSave.getOrderAdditionCarsId()));
//
//        long daysBetween = DAYS.between(order.getStartRent(), order.getEndRent());
//        double pricePerDay = order.getCar().getPricePerDay();
//
//        order.setTotalPrice(pricePerDay * daysBetween);
//
//        return order;
//    }

//     public Set<OrderAdditionCar> changeAdditionsIdtoAdditions(Long[] additionsIdArray) {
//        List<OrderAdditionCar> list = new ArrayList<>();
//
//        for (Long along : additionsIdArray) {
//            list.add(orderAdditionCarRepository.getOne(along));
//        }
//        return new HashSet<>(list);
//    }

//     public void addAdditionsToOrder(Long id, Long[] quantity, Long[] additionsId) {
//        List<Long> quantityWithoutNull = Arrays.stream(quantity)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        Order existing = orderRepository.findOne(id);
//
//        List<AdditionCar> additionCarList = new ArrayList<>();
//
//        for (Long along : additionsId) {
//            additionCarList.add(additionCarRepository.findOne(along));
//        }
//
//        for(Long along : quantityWithoutNull){
//
//        }
//
//    }
}
