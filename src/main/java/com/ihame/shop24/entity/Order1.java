package com.ihame.shop24.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Order1 {
    public Order1() {
    }

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "drink_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    List<Drink> drink;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
