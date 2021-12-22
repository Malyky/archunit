package com.consol.archunit.repository;

import com.consol.archunit.entity.Book;
import com.consol.archunit.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {


    ShoppingCart findShoppingCartByUser(String user);


}
