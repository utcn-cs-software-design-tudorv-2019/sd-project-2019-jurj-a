package com.example.FastPay.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.FastPay.data.entity.Bank;
import com.example.FastPay.data.entity.Card;
import com.example.FastPay.data.entity.Client;



@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {
	
}
