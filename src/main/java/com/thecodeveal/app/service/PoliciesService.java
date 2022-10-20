package com.thecodeveal.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thecodeveal.app.model.Policies;
import com.thecodeveal.app.repo.PoliciesRepository;

@Service
public class PoliciesService {

	@Autowired
	PoliciesRepository policiesRepository;
	
	public Policies savePolicies(Policies res) {
		return policiesRepository.save(res);
	}
	
	public List<Policies> getPolicies(){
		return policiesRepository.findAll();
	}
	
	public Policies getPolicies(String username) {
		return policiesRepository.findByUsername(username);
	}
	
	@Transactional
	public List<Policies> deletePolicies(String username) {
		return policiesRepository.deleteByUsername(username);
	}
	
	public String updatePolicies(String username, Policies policies) {
		Policies existingPolicies = policiesRepository.findByUsername(username);
		if(existingPolicies==null){
            return "Data Not Found";
        }
		existingPolicies.setUsername(username);
		existingPolicies.setHr(policies.getHr());
		existingPolicies.setIt(policies.getIt());
		existingPolicies.setNda(policies.getNda());
		
		policiesRepository.save(existingPolicies);
		return "Data updated successfully";
	}
}
