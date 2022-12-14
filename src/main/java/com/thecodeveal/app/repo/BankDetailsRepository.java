package com.thecodeveal.app.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thecodeveal.app.model.BankDetails;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {

	BankDetails findByUsername(String username);
	List<BankDetails> deleteByUsername(String username);
	List<BankDetails> findAll();
}
