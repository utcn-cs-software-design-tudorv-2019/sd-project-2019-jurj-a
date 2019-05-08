package com.example.FastPay.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	
	@GetMapping("/")
    public String getIndex()
    {
        return "index";
    }
	
	@GetMapping("AdminPage")
    public String getAdmintPage()
    {
        return "AdminPage";
    }
	
	@GetMapping("Login")
    public String getLoginPage()
    {
        return "Login";
    }
	
	
}
