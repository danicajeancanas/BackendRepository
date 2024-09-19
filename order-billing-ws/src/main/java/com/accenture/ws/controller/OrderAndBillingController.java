package com.accenture.ws.controller;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;
import com.accenture.ws.repository.OrderRepository;
import com.accenture.ws.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderAndBillingController {

    private OrderRepository orderRepo;

    private CafeClerk clerk;

    private OrderService orderService;

    @Autowired
    public OrderAndBillingController(OrderRepository orderRepo, CafeClerk clerk, OrderService orderService) {
        this.orderRepo = orderRepo;
        this.clerk = clerk;
        this.orderService = orderService;
    }

    //List of orders
    @GetMapping("/getOrders")
    public List<Order> getOrderList(){
        return orderService.getOrderList();
    }

    //Add order
    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    //Update an order
    @PutMapping("/updateOrder/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order){
        return orderService.updateOrder(id, order);
    }

    //Deleting an order
    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder (@PathVariable Long id){
        orderService.deleteOrder(id);
    }

    //Calculate total bill
    @GetMapping("/calculateTotalBill")
    public String calculateTotalBill(@RequestParam(defaultValue = "false") boolean isDiscounted){
        return orderService.calculateTotalBill(isDiscounted);
    }

    //Calling the clerk
    @GetMapping("/cafe-clerk")
    public String getCafeClerkInfo() {
        return clerk.getName();
    }
}
