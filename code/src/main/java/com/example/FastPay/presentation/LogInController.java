package com.example.FastPay.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FastPay.business.ClientService;
import com.example.FastPay.data.entity.Client;



@Controller
public class LogInController {
	
	@Autowired
	private ClientService clientService;

	@GetMapping("SignUpPage")
    public String getSignUpPage()
    {
        return "SignUpPage";
    }
	
	@GetMapping("ClientPage")
	public String getClientStudent(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		Client client = new Client(username,password);
		if(clientService.validate(client)) return "ClientPage";
		else return "Login";
		
    }
	
	
}
