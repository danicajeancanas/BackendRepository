package com.accenture.ws.entity;

public class DiscountedBill extends OrderBill {

    public DiscountedBill (CafeClerk clerk) {
        super (clerk);
    }

    public double getTotalBill(){
        double total = 0.0;
        for (Order order : getOrderList()) {
            double discount = order.isDiscounted() ? order.getPrice() * 0.05 : 0.0;
            total += order.getPrice() - discount;
        }
        return total;
    }
}
