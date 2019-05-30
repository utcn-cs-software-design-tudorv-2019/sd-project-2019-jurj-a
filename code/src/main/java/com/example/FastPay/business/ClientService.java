package com.example.FastPay.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FastPay.data.entity.Card;
import com.example.FastPay.data.entity.Client;
import com.example.FastPay.data.repository.ClientRepository;


@Service
public class ClientService {
	
	Client auxClient;
	
	@Autowired
	ClientRepository clientRepository;
	
	public List<Card> getCards(Client client){
		return clientRepository.getCreditCards(client.getClientName());
	}
	
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	public Client getClientByName(Client client) {
		return clientRepository.findByClientName(client.getClientName());
	}
	public void addClient(Client client) {
		clientRepository.save(client);
	}
	
	
	
	
	public boolean validate(Client client) {
		// TODO Auto-generated method stub
		
		if(clientRepository.findByClientName(client.getClientName()) == null)
			return false;
	
		auxClient = clientRepository.findByClientName(client.getClientName());
		
		
		
		if(auxClient.getpassword().equals(client.getpassword())) {
		System.out.printf("success");
		//System.out.print(clientRepository.getCreditCards(client.getClientName()).get(0).getCardName());
		return true;
		}
		else return false;
	}

}
