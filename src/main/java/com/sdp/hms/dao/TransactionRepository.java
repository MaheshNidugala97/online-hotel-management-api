package com.sdp.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp.hms.entity.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction, Long> {

}
