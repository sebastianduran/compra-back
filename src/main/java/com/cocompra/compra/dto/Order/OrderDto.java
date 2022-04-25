package com.cocompra.compra.dto.Order;

import java.util.List;

public class OrderDto {
    private List<OrderItemDto> orderItems;

    public OrderDto() {
    }

    public List<OrderItemDto> getCartItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

}
