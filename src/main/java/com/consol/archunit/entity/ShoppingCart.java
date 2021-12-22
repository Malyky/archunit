package com.consol.archunit.entity;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "SHOPPINGCART")
public class ShoppingCart {


    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER")
    private String user;

    @OneToMany
    @JoinColumn(name="ID")
    private List<Book> bookList;

}
