package com.accenture.ws.entity;

public class RegularBill extends OrderBill {

    public RegularBill (CafeClerk clerk){
        super(clerk);
    }

    @Override
    public double getTotalBill () {
        double total = 0.0;
        for (Order order: getOrderList()){
            total += order.getPrice();
        }
        return total;
    }
}
