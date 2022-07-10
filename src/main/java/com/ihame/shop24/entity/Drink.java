package com.ihame.shop24.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.swing.*;
import java.util.Date;

@Entity
public class Drink {

    public Drink() {
    }

    @Column(name = "drink_id")
    private @Id @GeneratedValue Long id;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "cargo_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Cargo cargo;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "order_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Order1 order1;

    private String name;

    private String quality;

    private Date expiredDate;

    private int  price;

    private String category;

    private int consumedTime;


    public int getConsumedTime() {
        return consumedTime;
    }

    public void setConsumedTime(int consumedTime) {
        this.consumedTime = consumedTime;
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

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Drink(Long id, String name, String quality, Date expiredDate, int price, String category) {
        this.id = id;
        this.name = name;
        this.quality = quality;
        this.expiredDate = expiredDate;
        this.price = price;
        this.category = category;
    }

    public Drink(String name, String quality, Date expiredDate, int price, String category, int consumedTime) {
        
        this.name = name;
        this.quality = quality;
        this.expiredDate = expiredDate;
        this.price = price;
        this.category = category;
        this.consumedTime = consumedTime;
    }

}
