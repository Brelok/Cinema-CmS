package com.github.brelok.orderAdditionCar;

import com.github.brelok.additionCar.AdditionCar;
import com.github.brelok.additionCar.AdditionCarRepository;
import com.github.brelok.order.Order;
import com.github.brelok.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
public class OrderAdditionCarService {

    private OrderAdditionCarRepository orderAdditionCarRepository;
    private AdditionCarRepository additionCarRepository;
    private OrderRepository orderRepository;


    @Autowired
    public OrderAdditionCarService(OrderAdditionCarRepository orderAdditionCarRepository, AdditionCarRepository additionCarRepository, OrderRepository orderRepository) {
        this.orderAdditionCarRepository = orderAdditionCarRepository;
        this.additionCarRepository = additionCarRepository;
        this.orderRepository = orderRepository;
    }

    public List<OrderAdditionCarDtoSave> findAllOrderAdditionCarDto() {
        List<OrderAdditionCar> list = orderAdditionCarRepository.findAll();

        return list.stream()
                .map(OrderAdditionCarDtoSave::new)
                .collect(Collectors.toList());
    }

    public Set<OrderAdditionCar> changeAdditionsIdtoAdditions(Long[] additionsIdArray) {
        List<OrderAdditionCar> list = new ArrayList<>();

        for (Long along : additionsIdArray) {
            list.add(orderAdditionCarRepository.getOne(along));
        }
        return new HashSet<>(list);
    }

    public OrderAdditionCarDtoSave findOneDto(Long id){
        return new OrderAdditionCarDtoSave(orderAdditionCarRepository.findOne(id));
    }


    public void save(Long id, Long[] quantity, Long[] additionsId) {

        Order existing = orderRepository.findOne(id); //znalezienie danego orderu

        List<Integer> quantityWithoutNull = Arrays.stream(quantity) //usuwanie null z listy. Lista wybranych ilości przez usera. Pozycja na liście odpowiada pozycji na liście additionCarList
                .filter(Objects::nonNull)
                .map(Long::intValue)
                .collect(Collectors.toList());

        List<AdditionCar> additionCarList = new ArrayList<>(); //lista wybranych dodatków przez usera

        for (Long along : additionsId) {
            additionCarList.add(additionCarRepository.findOne(along));
        }

        OrderAdditionCar orderAdditionCar = new OrderAdditionCar(); //tworzenie nowego obiektu
        int i = 0;
        for (AdditionCar additionCar : additionCarList) { //save total quantity
            additionCar.setTotalQuantity(additionCar.getTotalQuantity() - quantityWithoutNull.get(i));
            i++;

            orderAdditionCar.setAdditionCar(additionCar); //ustawianie nowych wartości
            orderAdditionCar.setAdditionQuantity(quantityWithoutNull.get(i));
            orderAdditionCar.setOrder(existing);
            orderAdditionCarRepository.save(orderAdditionCar);
        }





    }
}
