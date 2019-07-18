package com.github.brelok.additionCar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionCarRepository extends JpaRepository<AdditionCar, Long> {

    @Query(value = "SELECT additional_car_id FROM carrent_cms.order_addition_car WHERE order_id = ?1", nativeQuery = true)
    List<AdditionCar> findAllAdditionsCarInThisOrOrderBy(Long id);
}
