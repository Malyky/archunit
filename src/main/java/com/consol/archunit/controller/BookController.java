package com.consol.archunit.controller;

import com.consol.archunit.facade.BookBF;
import com.consol.archunit.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookBF bookBF;

    @Operation(summary = "Get a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @GetMapping("/book")
    public String getBooks(){

        String t = "test";
        t = bookBF.modifyOrder(t);

        // Iterable<OrderRepository> all = orderRepository.findAll();
        return t;

    }

}
