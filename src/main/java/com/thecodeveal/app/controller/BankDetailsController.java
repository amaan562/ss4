package com.thecodeveal.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thecodeveal.app.model.BankDetails;
import com.thecodeveal.app.service.BankDetailsService;

@RestController
public class BankDetailsController {

	@Autowired
	private BankDetailsService bankDetailsService;
	
	 @PostMapping("/bankDetails/{id}")
    public BankDetails saveBankDetails(@RequestBody BankDetails res){
        System.out.println("RES"+res);
        return bankDetailsService.saveBankDetails(res);
    }
	@GetMapping("/bankDetail")
	public List<BankDetails> getBankDetail() {
		return bankDetailsService.getBankDetails();
	}
    @GetMapping("/bankDetails/{id}")
    public BankDetails getBankDetails(@PathVariable("id") long id){
        return bankDetailsService.getBankDetailsById(id);
    }
    @DeleteMapping("/bankDetails/{id}")
    public String delResById(@PathVariable("id") long id){
        return bankDetailsService.deleteBankDetails(id);
    }
   @PutMapping("/bankDetails/{id}")
    public String updateRes(@PathVariable("id") long id,@RequestBody BankDetails resupdate){
        return bankDetailsService.updateBankDetails(id,resupdate);
    }
}
