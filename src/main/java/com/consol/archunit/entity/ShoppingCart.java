package com.consol.archunit.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "SHOPPINGCART")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShoppingCart {


    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER")
    private String user;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="shoppingcart_book", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="shoppingcart_id"))
    private List<Book> bookList;


    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
