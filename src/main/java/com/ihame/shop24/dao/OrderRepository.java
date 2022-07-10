package com.ihame.shop24.dao;

import com.ihame.shop24.entity.Drink;
import com.ihame.shop24.entity.Order1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order1, Long> {

}
