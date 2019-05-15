package com.example.FastPay.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "clients")

public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId = 0;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "cnp")
	private int cnp = 0;

	@Column(name = "address")
	private String address;

	@Column(name = "password")
	private String password;
	// optional
	@Column(name = "email")
	private String email = "";

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "bank", joinColumns = { @JoinColumn(name = "client_id") }, inverseJoinColumns = {
			@JoinColumn(name = "card_id") })
	private List<Card> creditCards;

	public Client() {
	}

	public Client(int clientId, String clientName, int cnp, String address, String password, String email) {
		this.clientId=clientId;
		this.clientName = clientName;
		this.cnp=cnp;
		this.address=address;
		this.password=password;
		this.email=email;
		this.creditCards = new ArrayList<Card>();
		
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Card> getCards() {
		return creditCards;
	}

	public void setCourses(ArrayList<Card> creditCards) {
		this.creditCards=creditCards;
	}
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getCnp() {
		return cnp;
	}

	public void setCnp(int cnp) {
		this.cnp = cnp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public List<Card> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<Card> creditCards) {
		this.creditCards = creditCards;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId &&
                cnp == client.cnp &&
                Objects.equals(password, client.password) &&
                Objects.equals(clientName, client.clientName) &&
                Objects.equals(address, client.address) &&
                Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clientId, clientName, cnp, address, password, email);
    }

    @Override
    public String toString() {
        return "Client " +
                "clientId=" + clientId +
                ", clientName='" + clientName +
                ", cnp=" + cnp +
                ", address=" + address +
                ", password=" + password +
                ", email=" + email ;

}

}
