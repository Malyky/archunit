package com.consol.archunit.facade;

import com.consol.archunit.activity.PaymentBA;
import com.consol.archunit.enums.PaymentOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentBF {

    @Autowired
    private PaymentBA paymentBA;


    public List<PaymentOptions> calculatePaymentMethod(String user) {
        return paymentBA.calculatePaymentMethod(user);
    }

}
