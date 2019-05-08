package com.example.FastPay.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FastPay.data.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {

}
