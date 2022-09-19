package com.ali.ark.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ali.ark.model.TransactionHistory;
import com.ali.ark.repository.TransactionHistoryRepository;

@Service
@Component
public class TransactionHistoryService {
	
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	
	public void addNewTransactionHistory(Integer fundId, Integer invId, Integer amount, String type) {
		try {
			TransactionHistory transaction = new TransactionHistory(fundId, invId, amount, type);
			transactionHistoryRepository.save(transaction);
		} catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
	}

	public String reportTransactions() {
		try {
			String report = "";
			for(TransactionHistory transaction: transactionHistoryRepository.findAll()) {
				report += (transaction.toString() + "\n");
			}
			return report;
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting transactions from repository");
		}
	}
	
}
