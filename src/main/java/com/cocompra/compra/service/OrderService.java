package com.cocompra.compra.service;

import com.cocompra.compra.dto.Cart.CartDto;
import com.cocompra.compra.dto.Cart.CartItemDto;
import com.cocompra.compra.dto.Order.OrderDto;
import com.cocompra.compra.dto.Order.OrderItemDto;
import com.cocompra.compra.model.Order;
import com.cocompra.compra.model.User;
import com.cocompra.compra.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Autowired
    ProductService productService;

    @Autowired
    OrderRepository orderRepository;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public OrderDto listOrders(User user) {
        List<Order> orderList = orderRepository.findAllByUserOrderByCreatedDateDesc(user);

        List<OrderItemDto> orderItems = new ArrayList<>();
        double totalCost = 0;
        for (Order order: orderList) {
            OrderItemDto orderItemDto = new OrderItemDto(order);
            orderItems.add(orderItemDto);
        }

        OrderDto orderDto = new OrderDto();
        orderDto.setOrderItems(orderItems);
        return  orderDto;
    }

}