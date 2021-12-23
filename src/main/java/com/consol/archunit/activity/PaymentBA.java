package com.consol.archunit.activity;

import com.consol.archunit.entity.Book;
import com.consol.archunit.entity.ShoppingCart;
import com.consol.archunit.enums.PaymentOptions;
import com.consol.archunit.facade.ShoppingCartBF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PaymentBA {

    @Autowired
    private ShoppingCartBF shoppingCartBF;

    public List<PaymentOptions> calculatePaymentMethod(String user) {
        ShoppingCart shoppingCartByUser = shoppingCartBF.getShoppingCartByUser(user);
        return calculatePaymentMethod(shoppingCartByUser);
    }

    private List<PaymentOptions> calculatePaymentMethod(ShoppingCart shoppingCart) {
        long price = shoppingCart.getBookList().stream().mapToInt(Book::getPrice).sum();

        if (price < 20) {
            return Collections.singletonList(PaymentOptions.PAYPAL);
        }

        // Do some more calulcations;
        return List.of(PaymentOptions.values());
    }
}
