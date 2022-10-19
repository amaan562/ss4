package com.thecodeveal.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thecodeveal.app.model.BankDetails;
import com.thecodeveal.app.service.BankDetailsService;

@CrossOrigin(origins="*")
@RestController
public class BankDetailsController {

	@Autowired
	private BankDetailsService bankDetailsService;
	
	 @PostMapping("/bankDetails")
    public BankDetails saveBankDetails(@RequestBody BankDetails res){
        System.out.println("RES"+res);
        return bankDetailsService.saveBankDetails(res);
    }
	@GetMapping("/bankDetail")
	public List<BankDetails> getBankDetail() {
		return bankDetailsService.getBankDetails();
	}
    @GetMapping("/bankDetails/{username}")
    public BankDetails getBankDetails(@PathVariable("username") String username){
        return bankDetailsService.getBankDetails(username);
    }
    @DeleteMapping("/bankDetails/{username}")
    public String delResById(@PathVariable("username") String username){
        return bankDetailsService.deleteBankDetails(username);
    }
   @PutMapping("/bankDetails/{username}")
    public String updateRes(@PathVariable("username") String username,@RequestBody BankDetails resupdate){
        return bankDetailsService.updateBankDetails(username,resupdate);
    }
}
