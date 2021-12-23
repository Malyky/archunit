package com.consol.archunit.controller;

import com.consol.archunit.entity.Book;
import com.consol.archunit.entity.ShoppingCart;
import com.consol.archunit.facade.ShoppingCartBF;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartBF shoppingCartBF;

    @Operation(summary = "Get a shopping cards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @GetMapping(value = "/shoppingCarts", produces = "application/json")
    public ResponseEntity<?> getShoppingCart(@Parameter(name ="user", example = "ConSol"
      /*      examples = {
                @ExampleObject(value = "ConSol")
            }*/
    )
                                                         String user)
    {

        ShoppingCart shoppingCartByUser = shoppingCartBF.getShoppingCartByUser(user);
        return new ResponseEntity<>(shoppingCartByUser, HttpStatus.OK);
    }

    @Operation(summary = "Some method")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = String.class)),
                            examples = {
                                    @ExampleObject(name = "Example 1", summary = "Summary 1", description = "Some desc", value = "[\"A\", \"B\"]"),
                                    @ExampleObject(name = "Example 2", summary = "Summary 2", description = "Some desc", value = "[\"C\", \"D\"]")
                            }
                    )
            })
    })
    @PostMapping(value = "/addBook", produces = "application/json")
    public ResponseEntity<?> addBook(@RequestBody(content = @Content(examples = {
            @ExampleObject(
                    name = "Person sample",
                    summary = "person example",
                    value =
                            "{\"bookId\": 1,"
                                    + "\"user\": \"ConSol\""
                                    + "}")
    })) HttpEntity<Map> mapHttpEntity){
        String user = (String) mapHttpEntity.getBody().get("user");
        Long bookId = (Long) Long.valueOf((Integer) mapHttpEntity.getBody().get("bookId"));
        shoppingCartBF.addBook(bookId, user);

        return new ResponseEntity<>("shoppingCart", HttpStatus.OK);
    }

}
