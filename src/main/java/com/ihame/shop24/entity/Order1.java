package com.ihame.shop24.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Order1 {
    public Order1() {
    }

    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private int TotalCost;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(int totalCost) {
        TotalCost = totalCost;
    }
    public Order1(Long id, String name, int totalCost) {
        this.id = id;
        this.name = name;
        TotalCost = totalCost;
    }
}
