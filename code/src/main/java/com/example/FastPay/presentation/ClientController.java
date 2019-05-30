package com.example.FastPay.presentation;

import com.example.FastPay.business.BankService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.FastPay.business.CardService;
import com.example.FastPay.business.ClientService;
import com.example.FastPay.data.entity.Card;
import com.example.FastPay.data.entity.Client;
import com.example.FastPay.data.entity.Money;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	
	private LogInController loginCtrl = new LogInController();
	
	
	private ModelAndView mv = new ModelAndView();
	@Autowired
	private ClientService clientService;
	@Autowired
	private CardService cardService;
	@Autowired
	private BankService bankService;
	
	@PostMapping(value="ClientPage",params="clientView")
	public ModelAndView allClients(){
		
		List<Client> e = clientService.getAllClients();
		
		mv.addObject("clients",e);
		return mv;
	}
	
	@GetMapping(value="Whatever2")
	public String transfer(@RequestParam("clname") String username,@RequestParam("cdname1") String cardname1,@RequestParam("cdname2") String cardname2,@RequestParam("amount") String amount){
		Client c1 = new Client();
		c1.setClientName(username);
		Card card1 = cardService.getCardByName(cardname1);
		Card card2 = cardService.getCardByName(cardname2);
		if(bankService.transferMoney(loginCtrl.getLoggedClient(),c1, card1,card2, Integer.parseInt(amount))) return "ClientPage";
		else return "Login";
	}
	
	
	@PostMapping(value="ClientPage",params="convertM")
	public ModelAndView convert(@RequestParam("amountRon") String amount)throws IOException{
		
		String addr = new String("https://www.x-rates.com/table/?from=RON&amount=");
		
		
		Document doc = Jsoup.connect(addr+amount).get();

		Elements rows = doc.select("table.ratesTable > tbody > tr");
		String eur = new String();
		String usd = new String();
		
		List<String> x = new ArrayList<String>();

		for (Element row : rows) {
		    Elements tds = row.select("td");
		    
		    if(tds.get(0).text().equals("US Dollar")) {
		    	usd = tds.get(1).text();
		    }
		    
		    if(tds.get(0).text().equals("Euro")) {
		    	eur = tds.get(1).text();
		    }
		   
		}
		
		Money m = new Money(eur,usd);
		
		List<Money> e = new ArrayList<Money>();
		
		e.add(m);
		
		mv.addObject("moneys", e);
		
		return mv;
	}
	
	@PostMapping(value="ClientPage",params="buttonView")
	public ModelAndView clientCards(){
		Client x =clientService.getClientByName(loginCtrl.getLoggedClient());
		List<Card> e = clientService.getCards(x);
		mv.addObject("cards",e);
		return mv;
	}
	
}
