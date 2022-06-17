package com.ihame.shop24.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {


    @Id
    @GeneratedValue()
    @Column(name = "client_id")
    private Long id;
    private String ClientName;
    private String Productname;
    private String address;
    private int Quntity;

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public Client() {
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        this.ClientName = clientName;
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
        this.ClientName = name;
        this.address = address;
        this.id = id;
        Quntity = quntity;
        Productname =productname;
    }
}
