package com.thecodeveal.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="BANK_DETAILS")
@Entity
public class BankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ifsc")
	private String ifsc;
	
	@Column(name = "pan")
	private String pan;
	
	@Column(name = "accountNumber")
	private String accountNumber;
	
	@Column(name = "firstEmployment")
	private boolean firstEmployment;
	
//	@ManyToMany(cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
//	@JoinTable(name="AUTH_USER_DETAILS",
//			   joinColumns = @JoinColumn(referencedColumnName = "id"),
//			   inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isFirstEmployment() {
		return firstEmployment;
	}

	public void setFirstEmployment(boolean firstEmployment) {
		this.firstEmployment = firstEmployment;
	}
	
	
}
