package com.consol.archunit.controller;

import com.consol.archunit.entity.Book;
import com.consol.archunit.facade.BookBF;
import com.consol.archunit.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
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
    @GetMapping("")
    public ResponseEntity<?> getBooks(){

        List<Book> books = bookBF.getBooks();
        // Iterable<OrderRepository> all = orderRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    @Operation(summary = "Get a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book){

        bookBF.saveBook(book);
        // Iterable<OrderRepository> all = orderRepository.findAll();
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
