package com.example.FastPay.presentation;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FastPay.business.AdminService;
import com.example.FastPay.business.CardService;
import com.example.FastPay.business.ClientService;
import com.example.FastPay.data.entity.Admin;
import com.example.FastPay.data.entity.Card;
import com.example.FastPay.data.entity.Client;

@Controller
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private AdminService adminService;
	
	private LogInController loginController;
	
	@GetMapping("Whatever7")
	public String saveCard(@RequestParam("cardname") String cardname,@RequestParam("balance") String balance,@RequestParam("date_exp") String dateexp)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
		
		if(cardname.equals("")||balance.equals("")||dateexp.equals("")) return "ClientPage";
		
		
		Optional<Admin> a = adminService.getAdmin();
		
		int cid = adminService.getIDCourse();
		//y.setAdmin(z);
		Card y = new Card(cid,cardname,Integer.parseInt(balance),LocalDate.parse(dateexp,formatter),a.get());
		cardService.addCard(y,loginController.getLoggedClient());
		return "ClientPage";
		}
		
    }

