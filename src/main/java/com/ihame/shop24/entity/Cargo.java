package com.ihame.shop24.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cargo {

    public Cargo() {
    }
    private String companyName;
    @Id
    @GeneratedValue()
    @Column(name = "cargo_id")
    private Long id;
    private Date startDate;
    private Date DeriveredDate;

    //relationship
//    @OneToMany(mappedBy = "cargo")
//    private List< Drink> drinks;
//    private Set<Integer> drinksIds = new HashSet<Integer>();
//    private Set<Drink> drinks = new HashSet<Drink>();

    public Date getDeriveredDate() {
        return DeriveredDate;
    }

    public void setDeriveredDate(Date deriveredDate) {
        DeriveredDate = deriveredDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

//    public List<Drink> getDrinks() {
//        return drinks;
//    }

    public Cargo(String companyName, Long id, Date startDate) {
        this.companyName = companyName;
        this.id = id;
        this.startDate = startDate;
    }

//    @PrePersist
//    @PreUpdate
//    public void populateCargo; {
//        for(Drink drink : drinks)
//            drinks.add(drink);
//    }


}
