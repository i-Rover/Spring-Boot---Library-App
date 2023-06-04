package com.luv2code.springbootlibrary.dao;

import com.luv2code.springbootlibrary.entity.Checkout;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CheckoutRepository extends JpaRepository <Checkout, Long> {
    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);
    List<Checkout> findBooksByUserEmail(String userEmail);
    @Modifying
    @Query("delete from Checkout c where c.bookId in :book_id")
    void deleteAllByBookId(@Param("book_id") Long bookId);
}

