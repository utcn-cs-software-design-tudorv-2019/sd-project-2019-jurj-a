package com.example.FastPay.presentation;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FastPay.business.ClientService;
import com.example.FastPay.data.entity.Client;



@Controller
public class LogInController {
	
	public static Client client = new Client();
	
	private static int loginFlag=0;
	
	@Autowired
	private ClientService clientService;

	@GetMapping("SignUpPage")
    public String getSignUpPage()
    {
        return "SignUpPage";
    }
	
	@GetMapping("ClientPage")
	public String getClientStudent(@RequestParam("username") String username,@RequestParam("password") String password) throws IOException
	{
		
		if(username.equals("")) return "Login";
		
		client.setClientName(username);
		client.setpassword(password);
		
		
		
		if(clientService.validate(client)) {
			loginFlag=1;
			return "ClientPage";}
		else return "Login";
		
    }
	
	public static Client getLoggedClient() {
		if(loginFlag==1) return client;
		else return new Client();
	}
	
}
