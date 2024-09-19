package com.accenture.ws.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;

import java.text.NumberFormat;
import java.util.Locale;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderName;
    private double price;
    private boolean isDiscounted;
    private double isDiscountPercentage = 5.0;

    public Order(){

    }

    public Order(String orderName, double price, boolean isDiscounted) {
        this.orderName = orderName;
        this.price = price;
        this.isDiscounted = isDiscounted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscounted() {
        return isDiscountPercentage == 5.0;
    }


    public void setIsDiscountPercentage(double isDiscountPercentage) {
        if (isDiscountPercentage == 5.0 || isDiscountPercentage == 0.0){
            this.isDiscountPercentage = isDiscountPercentage;
        } else{
            throw new IllegalArgumentException("Discount percentage must be either 5.0 or 0.0");
        }
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    public double getIsDiscountPercentage() {
        return isDiscountPercentage;
    }


}
