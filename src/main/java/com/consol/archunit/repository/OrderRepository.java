package com.consol.archunit.repository;

import com.consol.archunit.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Book, Long> {




}
