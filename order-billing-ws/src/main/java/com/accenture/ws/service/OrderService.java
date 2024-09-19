package com.accenture.ws.service;

import com.accenture.ws.entity.Order;

import java.util.List;


public interface OrderService {

    Order addOrder (Order order);

    List<Order> getOrderList();

    Order updateOrder (Long id, Order order);

    void deleteOrder(Long id);

    String calculateTotalBill(boolean isDiscounted);
}
