package com.ihame.shop24;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Drink {

    public Drink() {
    }
//
//    private @Id @GeneratedValue Long id;
//    private String firstname;
//    private String lastname;
//    private int age;
//    private String gender;
//    private String category;


    private @Id @GeneratedValue Long id;
    private String name;
    private String quality;
    private Date expiredDate;
    private int  price;
    private String category;

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

    //    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//
//
//
//    public Drink(String firstname, String lastname, int age, String gender, String category) {
//
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.age = age;
//        this.gender = gender;
//        this.category = category;
//    }
}
