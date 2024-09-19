package com.accenture.ws.service.impl;

import com.accenture.ws.entity.*;
import com.accenture.ws.exception.BadRequestException;
import com.accenture.ws.repository.OrderRepository;
import com.accenture.ws.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private CafeClerk cafeClerk;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CafeClerk cafeClerk) {
        this.orderRepository = orderRepository;
        this.cafeClerk = cafeClerk;
    }

    //Adding an order
    @Override
    public Order addOrder(Order order) {
        if (order.getPrice() < 2){
            throw new RuntimeException ("Unable to add order. Something went wrong.");
        }
        order.getIsDiscountPercentage();
        order.setDiscounted(order.isDiscounted());
        return orderRepository.save(order);
    }

    //Showing all orders
    @Override
    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    //Update an order
    @Override
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Order not found with id: " + id));
        existingOrder.setOrderName(order.getOrderName());
        existingOrder.setPrice(order.getPrice());
        existingOrder.setIsDiscountPercentage(order.getIsDiscountPercentage());
        existingOrder.setDiscounted(order.isDiscounted());
        return orderRepository.save(existingOrder);
    }

    //Deleting an order
    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new BadRequestException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }

    //Calculating total bill
    public String calculateTotalBill(boolean isDiscounted){
        OrderBill bill;
        String message;
        if (isDiscounted){
            bill = new DiscountedBill(cafeClerk);
            message = "Total Discounted Bill: ";
        }else{
            bill = new RegularBill(cafeClerk);
            message = "Total Regular Bill: ";
        }
        bill.setOrderList(getOrderList());
        return "Attending Clerk: " + cafeClerk.getName() + "\n" + message + bill.getTotalBill();
    }
}
