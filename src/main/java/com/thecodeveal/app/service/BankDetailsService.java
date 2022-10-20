package com.thecodeveal.app.service;

import java.util.*;

import javax.transaction.Transactional;

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
	
	@Transactional
	public List<BankDetails> deleteBankDetails(String username){
        return bankDetailsRepository.deleteByUsername(username);
    }
	
	public String updateBankDetails(String username, BankDetails res) {
		BankDetails existingRes = bankDetailsRepository.findByUsername(username);
		if(existingRes==null){
            return "Data Not Found";
        }
		existingRes.setUsername(username);
		existingRes.setAccountNumber(res.getAccountNumber());
		existingRes.setFirstEmployment(res.isFirstEmployment());
		existingRes.setIfsc(res.getIfsc());
		existingRes.setPan(res.getPan());
		
		bankDetailsRepository.save(existingRes);
		return "Details updated successfully";
	}
}
