package com.example.FastPay.data.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="cards")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;
	
	@Column(name="card_name")
	private String cardName;
	
	@Column(name="balance")
	private int balance;
	
	@Column(name = "date_exp",columnDefinition="DATE")
	private LocalDate dateExp;
	
	@ManyToOne(targetEntity = Admin.class)
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "bank", joinColumns = { @JoinColumn(name = "card_id") }, inverseJoinColumns = {
			@JoinColumn(name = "client_id") })
	private List<Client> clients;
	
	public Card(int cardId, String cardName, int balance,LocalDate dateExp, Admin admin2) {
		
		System.err.println(cardId);
		this.cardId=cardId;
		this.cardName=cardName;
		this.balance=balance;
		this.dateExp=dateExp;
		this.admin = admin2;
		this.clients = new ArrayList<Client>();
		
	}
	
	public Card(String cardName, int balance,LocalDate dateExp) {
		
		this.cardName=cardName;
		this.balance=balance;
		this.dateExp=dateExp;
		this.clients=new ArrayList<Client>();
 	}
	
	public  Card() {}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public LocalDate getDateExp() {
		return dateExp;
	}

	public void setDateExp(LocalDate dateExp) {
		this.dateExp = dateExp;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		Card card = (Card) o;
		return cardId == card.cardId && balance == card.balance && Objects.equals(cardName, card.cardName)
				&& Objects.equals(dateExp,card.dateExp) && Objects.equals(admin, card.admin);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cardId,cardName,balance, dateExp, admin);
	}
	
	@Override
	public String toString() {
		
		return "Card " + "cardId= " + cardId + " ,cardName= " + cardName
				+", balance=" + balance + ", dateExp= " + dateExp;
		
		
	}
}
