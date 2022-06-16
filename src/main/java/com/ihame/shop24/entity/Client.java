package com.ihame.shop24.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    private String name;
    private String address;
    @Id
    @GeneratedValue()
    private Long id;
    private int Quntity;

    private String Productname;

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuntity() {
        return Quntity;
    }

    public void setQuntity(int quntity) {
        Quntity = quntity;
    }

    public Client(String name, String address, Long id, int quntity, String productname) {
        this.name = name;
        this.address = address;
        this.id = id;
        Quntity = quntity;
        Productname =productname;
    }
}
