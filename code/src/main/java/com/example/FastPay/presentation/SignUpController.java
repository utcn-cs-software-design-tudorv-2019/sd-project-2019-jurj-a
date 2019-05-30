package com.example.FastPay.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FastPay.business.ClientService;
import com.example.FastPay.data.entity.Client;

@Controller
public class SignUpController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("Whatever")
	public String saveClient(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("cnp") String cnp,@RequestParam("address") String address,@RequestParam("password") String password)
	{
		
		if(username.equals("")||email.equals("")||address.equals("")||password.equals("")) return "Login";
		
		Client x = new Client();
		x.setClientName(username);
		x.setpassword(password);
		x.setAddress(address);
		x.setCnp(Integer.parseInt(cnp));
		x.setEmail(email);
		
		if(clientService.validate(x)) {
			return "Login";}
		else {
			clientService.addClient(x);
			return "Login";
		}
		
    }
	
}
