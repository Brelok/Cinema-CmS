package com.github.brelok.orderAdditionCar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAdditionCarRepository extends JpaRepository<OrderAdditionCar, Long> {
}
