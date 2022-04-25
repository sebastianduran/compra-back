package com.cocompra.compra.repository;

import com.cocompra.compra.model.Order;
import com.cocompra.compra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);
}
