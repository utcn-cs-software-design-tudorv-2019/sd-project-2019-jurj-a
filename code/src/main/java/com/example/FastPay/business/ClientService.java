package com.example.FastPay.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FastPay.data.entity.Client;
import com.example.FastPay.data.repository.ClientRepository;


@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	public boolean validate(Client client) {
		// TODO Auto-generated method stub
		
		Client auxClient = clientRepository.findByClientName(client.getClientName());
		
		
		if(auxClient.getpassword().equals(client.getpassword())) {
		System.out.printf("success");
		return true;
		}
		else return false;
	}

}
