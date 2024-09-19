package com.accenture.ws;

import com.accenture.ws.entity.Order;
import com.accenture.ws.repository.OrderRepository;
import com.accenture.ws.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class OrderTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddOrder_DiscountedFieldIsTrue() {
        // Arrange
        Order order = new Order("Test Order", 100.0, false);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        // Act
        Order savedOrder = orderService.addOrder(order);

        // Assert
        assertTrue(savedOrder.isDiscounted(), "The isDiscounted field should be true");

    }
}