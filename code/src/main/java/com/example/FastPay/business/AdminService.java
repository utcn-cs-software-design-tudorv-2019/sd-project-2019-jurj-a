package com.example.FastPay.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FastPay.data.entity.Admin;
import com.example.FastPay.data.entity.Card;
import com.example.FastPay.data.repository.AdminRepository;
import com.example.FastPay.data.repository.CardRepository;


@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CardRepository cardRepository;
	
	public void addAdmin(Admin admin) {
		adminRepository.save(admin);
	}

	public Optional<Admin> getAdmin()
    {
        return adminRepository.findById(0);
    }
	
	public int getIDCourse()
    {
       List<Card> c= new ArrayList<Card>();
       c=cardRepository.findAll();
       return c.size()+1;

    }
}
