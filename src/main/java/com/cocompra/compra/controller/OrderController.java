package com.cocompra.compra.controller;

import com.cocompra.compra.common.ApiResponse;
import com.cocompra.compra.dto.Checkout.CheckoutItemDto;
import com.cocompra.compra.dto.Order.OrderDto;
import com.cocompra.compra.model.User;
import com.cocompra.compra.service.AuthenticationService;
import com.cocompra.compra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/create-checkout-session")
    public ResponseEntity<ApiResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList) {
        ApiResponse stripeResponse = new ApiResponse(true, "Simuacion de pago (se pude usar stripe api");
        return new ResponseEntity<>(stripeResponse, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<OrderDto> getOrderItem(@RequestParam("token") String token) {
        // authenticate the token
        authenticationService.authenticate(token);

        // find the user
        User user = authenticationService.getUser(token);

        // get order items

        OrderDto orderDto = orderService.listOrders(user);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }
}
