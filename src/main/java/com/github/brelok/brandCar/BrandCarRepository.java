package com.github.brelok.brandCar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandCarRepository extends JpaRepository<BrandCar, Long> {
}
