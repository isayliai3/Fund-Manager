package com.ali.ark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_HISTORY")
public class TransactionHistory {
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private Integer fundId;
	
	@Column
	private Integer investorId;
	
	@Column
	private Integer amount;
	
	@Column
	private String transactionType;
	
	public TransactionHistory(Integer fundId, Integer investorId, Integer amount, String transactionType) {
		this.fundId = fundId;
		this.investorId = investorId;
		this.amount = amount;
		this.transactionType = transactionType;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getFundId() {
		return fundId;
	}


	public void setFundId(Integer fundId) {
		this.fundId = fundId;
	}


	public Integer getInvestorId() {
		return investorId;
	}


	public void setInvestorId(Integer investorId) {
		this.investorId = investorId;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String toString() {
		return "\"Transaction\": {\n" + 
				"\t\"ID\": " + this.getId() + "\n" +
				"\t\"Fund ID\": " + this.getFundId() + "\n" +
				"\t\"Investor ID\": " + this.getInvestorId() + "\n" +
				"\t\"Transaction Type\": " + this.getTransactionType() + "\n" +
				"\t\"Amount\": " + this.getAmount() + "\n" +
				"}";
	}
	
}
