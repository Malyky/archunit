package com.consol.archunit.entity;

import javax.persistence.*;

@Entity()
@Table(name = "BOOK")
public class Book {


        @Id
        @GeneratedValue
        @Column(name = "ID")
        private Long id;

        @Column(name = "NAME")
        private String name;


        public Book() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
}
