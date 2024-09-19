package com.accenture.ws.entity;

import java.util.List;

public class OrderBill {

    private List<Order> orderList;
    private CafeClerk clerk;

    public OrderBill(CafeClerk clerk) {
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public CafeClerk getClerk() {
        return clerk;
    }

    public double getTotalBill() {
        return 0.0;
    }
}
