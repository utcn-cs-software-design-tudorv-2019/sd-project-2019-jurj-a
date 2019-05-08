package com.example.FastPay.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FastPay.data.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

}
