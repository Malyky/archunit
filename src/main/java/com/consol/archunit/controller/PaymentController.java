package com.consol.archunit.controller;

import com.consol.archunit.enums.PaymentOptions;
import com.consol.archunit.facade.PaymentBF;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentBF paymentBF;

    @Operation(summary = "Pay for Shoppingcart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @GetMapping(value = "/paymentOptions", produces = "application/json")
    public ResponseEntity<?> payment(@Parameter(name ="user", example = "ConSol") String user){

        List<PaymentOptions> paymentOptions = paymentBF.calculatePaymentMethod(user);
        return new ResponseEntity<>(paymentOptions, HttpStatus.OK);

    }
}
