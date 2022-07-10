package com.ihame.shop24.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cargo {

    public Cargo() {
    }
    @Id
    @GeneratedValue()
    @Column(name = "cargo_id")
    private Long id;
    private String companyName;
    private Date startDate;
    private Date DeriverDate;
    private String CargoAddress;


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

    public String getCargoAddress() {
        return CargoAddress;
    }
    public void setCargoAddress(String cargoAddress) {
        CargoAddress = cargoAddress;
    }

    public Date getDeriverDate() {
        return DeriverDate;
    }

    public void setDeriverDate(Date deriverDate) {
        DeriverDate = deriverDate;
    }
    public Cargo(String companyName, Long id, String cargoAddress, Date startDate, Date deriverDate) {
        this.companyName = companyName;
        this.id = id;
        CargoAddress = cargoAddress;
        this.startDate = startDate;
        DeriverDate = deriverDate;
    }

    public Cargo(String companyName, Date startDate, Date deriverDate, String cargoAddress) {
        this.companyName = companyName;
        this.startDate = startDate;
        DeriverDate = deriverDate;
        CargoAddress = cargoAddress;
    }
}
