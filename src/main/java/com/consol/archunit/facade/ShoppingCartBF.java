package com.consol.archunit.facade;

import com.consol.archunit.activity.ShoppingCartBA;
import com.consol.archunit.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartBF {

    @Autowired
    private ShoppingCartBA shoppingCartBA;


    public ShoppingCart getShoppingCartByUser(String user) {
        ShoppingCart shoppingCart = shoppingCartBA.getShoppingCartByUser(user);
        return shoppingCart;

    }

    public void addBook(Long id, String user){
        shoppingCartBA.addBookToBasket(id, user);
    }


}
