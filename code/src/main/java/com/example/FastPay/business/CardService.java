package com.example.FastPay.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FastPay.data.entity.Admin;
import com.example.FastPay.data.entity.Card;
import com.example.FastPay.data.entity.Client;
import com.example.FastPay.data.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;
	
	AdminService adminService;
	
	ClientService clientService;
	
	BankService bankService;
	
	public Card getCardByName(String cardname) {
		return cardRepository.findByCardName(cardname);
	}
	
	public boolean addCard(Card card, Client client) {
		
		if(client.equals(null)) return false;
		
		if(card.equals(null)) return false;
		
		
		cardRepository.save(card);
		
		if(bankService.addConnection(client, card)) return true;
		else return false;
		
	}
	
	
}
