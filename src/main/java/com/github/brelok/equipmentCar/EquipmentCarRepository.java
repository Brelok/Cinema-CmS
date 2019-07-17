package com.github.brelok.equipmentCar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentCarRepository extends JpaRepository<EquipmentCar, Long> {
}
