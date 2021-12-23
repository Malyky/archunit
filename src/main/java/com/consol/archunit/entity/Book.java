package com.consol.archunit.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity()
@Table(name = "BOOK")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long bookId;

        @Column(name = "NAME")
        private String name;

        @Column(name = "PRICE")
        private int price;
}
