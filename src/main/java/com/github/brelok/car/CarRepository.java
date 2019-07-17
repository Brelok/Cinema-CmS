package com.github.brelok.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    long countByStatus(Boolean status);

//    List findAllAdditionsInWholeCar();
}