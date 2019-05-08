package com.example.FastPay.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FastPay.data.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

	public Client findByUsername(String username);
	
}
