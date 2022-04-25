package com.cocompra.compra.dto.Order;

import com.cocompra.compra.model.Order;
import com.cocompra.compra.model.Product;

public class OrderItemDto {

    private Integer id;

    public OrderItemDto() {
    }

    public Integer getId() {
        return id;
    }
    public OrderItemDto(Order order){
        this.id = order.getId();
    }
}
