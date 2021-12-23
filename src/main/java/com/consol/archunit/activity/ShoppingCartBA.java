package com.consol.archunit.activity;

import com.consol.archunit.entity.Book;
import com.consol.archunit.entity.ShoppingCart;
import com.consol.archunit.facade.BookBF;
import com.consol.archunit.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartBA {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private BookBF bookBF;

    public ShoppingCart getShoppingCartByUser(String user) {
        return shoppingCartRepository.findShoppingCartByUser(user);
    }

    public void addBookToBasket(Long id, String user) {
        ShoppingCart shoppingCartByUser = shoppingCartRepository.findShoppingCartByUser(user);
        Book book = bookBF.getBookById(id);
        shoppingCartByUser.getBookList().add(book);
        shoppingCartRepository.save(shoppingCartByUser);
    }
}
