package com.cocompra.compra.controller;

import com.cocompra.compra.common.ApiResponse;
import com.cocompra.compra.dto.Checkout.CheckoutItemDto;
import com.cocompra.compra.service.AuthenticationService;
import com.cocompra.compra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private OrderService orderService;

    // stripe session checkout api

    @PostMapping("/create-checkout-session")
    public ResponseEntity<ApiResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList) {
        ApiResponse stripeResponse = new ApiResponse(true, "Simuacion de pago (se pude usar stripe api");
        return new ResponseEntity<>(stripeResponse, HttpStatus.OK);
    }
}