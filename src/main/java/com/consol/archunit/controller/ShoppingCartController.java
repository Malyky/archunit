package com.consol.archunit.controller;

import com.consol.archunit.entity.ShoppingCart;
import com.consol.archunit.repository.ShoppingCartRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Operation(summary = "Get a shopping cards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @GetMapping(value = "/shoppingCarts", produces = "application/json")
    public ResponseEntity<ShoppingCart> getShoppingCart(){

        String t = "test";
        List<ShoppingCart> all1 = shoppingCartRepository.findAll();
        ShoppingCart all = shoppingCartRepository.findShoppingCartByUser("ConSol");
        // Iterable<OrderRepository> all = orderRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);

    }
}
