package com.ihame.shop24.entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Order1 {
    public Order1() {
    }

//    @OneToMany(mappedBy = "order1", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Drink> drinks;
//
//    public List<Drink> getDrinks() {
//        return drinks;
//    }
//
//    public void setDrinks(List<Drink> drinks) {
//        this.drinks = drinks;
//    }

    @Id
    @GeneratedValue()
    private Long id;
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "client_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    Client client;

    private  int clientId;
    private boolean completed=false;


    @Column
    @ElementCollection(targetClass = Long.class)
    private List<Long> drinkId;

    private String name;
    private int TotalCost;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public List<Long> getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(List<Long> drinkId) {
        this.drinkId = drinkId;
    }

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Order1(Long id, String name, int totalCost) {
        this.id = id;
        this.name = name;
        TotalCost = totalCost;
    }

    public Order1(String name, int totalCost) {
        this.name = name;
        TotalCost = totalCost;
    }

    public void addDrink(Long drinkId){
        getDrinkId().add(drinkId);
    }
}

