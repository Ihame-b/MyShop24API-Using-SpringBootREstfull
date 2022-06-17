package com.ihame.shop24.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.util.List;

@Entity
public class Order1 {
    public Order1() {
    }

    @OneToMany(mappedBy = "order1", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Drink> drinks;

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    @Id
    @GeneratedValue()
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Order1(List<Drink> drinks, Long id, Client client, String name, int totalCost) {
        this.drinks = drinks;
        this.id = id;
        this.client = client;
        this.name = name;
        TotalCost = totalCost;
    }
}
