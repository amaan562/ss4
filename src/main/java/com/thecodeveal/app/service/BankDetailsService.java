package com.thecodeveal.app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.thecodeveal.app.model.BankDetails;
import com.thecodeveal.app.repo.BankDetailsRepository;

@Service
public class BankDetailsService {

	@Autowired
	BankDetailsRepository bankDetailsRepository;
	
	public BankDetails saveBankDetails(BankDetails res) {
		return bankDetailsRepository.save(res);
	}
	
	public List<BankDetails> getBankDetails() {
		return bankDetailsRepository.findAll();
	}
	
	public BankDetails getBankDetails(String username) {
		return bankDetailsRepository.findByUsername(username);
	}
	
	public String deleteBankDetails(String username){
        bankDetailsRepository.deleteByUsername(username);
        return "resource removed of username "+username;
    }
	
	public String updateBankDetails(String username, BankDetails res) {
		BankDetails existingRes = bankDetailsRepository.findByUsername(username);
		if(existingRes==null){
            return "Data Not Found";
        }
		existingRes.setAccountNumber(res.getAccountNumber());
		existingRes.setFirstEmployment(res.isFirstEmployment());
		existingRes.setIfsc(res.getIfsc());
		existingRes.setPan(res.getPan());
		
		bankDetailsRepository.save(existingRes);
		return "Details updated successfully";
	}
}
