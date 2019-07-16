package com.github.brelok.classCar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassCarRepository extends JpaRepository<ClassCar, Long> {
}
