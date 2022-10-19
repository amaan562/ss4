package com.thecodeveal.app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public BankDetails getBankDetailsById(long id) {
		return bankDetailsRepository.findById(id);
	}
	
	public String deleteBankDetails(long id){
        bankDetailsRepository.deleteById(id);
        return "resource removed of id"+id;
    }
	
	public String updateBankDetails(long id, BankDetails res) {
		BankDetails existingRes = bankDetailsRepository.findById(id);
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
