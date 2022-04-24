package com.cocompra.compra.repository;

import com.cocompra.compra.model.Cart;
import com.cocompra.compra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
