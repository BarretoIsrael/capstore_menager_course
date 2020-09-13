package com.barreto.developer.capstroremenager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface CapRepository extends JpaRepository<Book, Long> {


}
