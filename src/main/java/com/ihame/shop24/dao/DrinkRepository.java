package com.ihame.shop24.dao;

import com.ihame.shop24.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findByCargoId(Long cargoID);
}
