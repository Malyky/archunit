package com.consol.archunit.facade;

import org.springframework.stereotype.Component;

@Component
public class BookBF {

    public String modifyOrder(String order){

        return order + Math.random();
    }
}
