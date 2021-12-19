package com.consol.archunit.facade;

import org.springframework.stereotype.Component;

@Component
public class OrderBF {

    public String modifyOrder(String order){

        return order + Math.random();
    }
}
