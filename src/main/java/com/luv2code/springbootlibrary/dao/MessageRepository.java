package com.luv2code.springbootlibrary.dao;

import com.luv2code.springbootlibrary.entity.Messages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public interface MessageRepository extends JpaRepository<Messages, Long> {
    Page<Messages> findByUserEmail(@RequestParam("userEmail")String userEmail, Pageable pageable);
}
