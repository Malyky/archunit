package com.consol.archunit.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "SHOPPINGCART")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShoppingCart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long shoppingcartId;

    @Column(name = "USER")
    private String user;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="shoppingcart_book", joinColumns=@JoinColumn(name="shoppingcart_id"), inverseJoinColumns=@JoinColumn(name="book_id"))
    private List<Book> bookList = new ArrayList<>();

}
