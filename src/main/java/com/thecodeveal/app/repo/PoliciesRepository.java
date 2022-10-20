package com.thecodeveal.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thecodeveal.app.model.Policies;

@Repository
public interface PoliciesRepository extends JpaRepository<Policies, Long>{
	
	Policies findByUsername(String username);
	List<Policies> deleteByUsername(String username);
	List<Policies> findAll();
}
