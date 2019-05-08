package com.example.FastPay.data.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="bank")
public class Bank {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int bankId;
	
	@ManyToOne()
	@JoinColumn(name= "client_id")
	private Client client;
	
	@ManyToOne()
	@JoinColumn(name = "card_id")
	private Card card;
	
	
	
	public Bank(Client clients, Card cards) {
		
		this.client=clients;
		this.card = cards;
	}
	
	public Bank() {}
	
	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(this==o)
			return true;
		if(o==null || getClass() != o.getClass())
			return false;
		Bank that = (Bank) o;
		return bankId == that.bankId && Objects.equals(client, that.client)
				&& Objects.equals(card, that.card);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(bankId,client,card);
	}
	
	@Override
	public String toString() {
		return "Bank " + " bankId = " + bankId + ", clients= " + client+ " cards=" + card;
	}
}
