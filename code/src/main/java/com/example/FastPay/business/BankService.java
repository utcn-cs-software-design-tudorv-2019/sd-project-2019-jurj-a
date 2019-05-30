package com.example.FastPay.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.example.FastPay.data.entity.Bank;
import com.example.FastPay.data.entity.Card;
import com.example.FastPay.data.entity.Client;


import com.example.FastPay.data.repository.BankRepository;
import com.example.FastPay.data.repository.CardRepository;
import com.example.FastPay.data.repository.ClientRepository;

@Service
public class BankService {

	
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CardRepository cardRepository;
	
	public boolean addConnection(Client client, Card card) {
		
		Bank x = new Bank();
		
		x.setCard(card);
		x.setClient(client);
		
		bankRepository.save(x);
		
		return true;
	}
	
	
	public boolean transferMoney(Client client1, Client client2, Card cardx1, Card cardx2, int amount) {
		
		Client clientaux = clientRepository.findByClientName(client2.getClientName());
		if(clientaux.equals(null)) return false;
		
		List<Bank> connections = bankRepository.findAll();
		
		
		
		Card card1 = cardRepository.findByCardName(cardx1.getCardName());
		if(card1.equals(null)) return false;
		Card card2 = cardRepository.findByCardName(cardx2.getCardName());
		if(card2.equals(null)) return false;
		
		int count=0;
		for(Bank b : connections) {
			if(b.getClient().equals(clientaux)) {
				if(b.getCard().equals(card2)) {
					
					//cardRepository.delete(card1);
					card1.setBalance(card1.getBalance()-amount);
					cardRepository.save(card1);
					
					
					
					//cardRepository.delete(card2);
					card2.setBalance(card2.getBalance()+amount);
					cardRepository.save(card2);
					
				}
			}
		}
			
		return true;
	}
}
