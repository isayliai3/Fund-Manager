package com.ali.ark.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ali.ark.fundmanager.TransactionType;
import com.ali.ark.model.Fund;
import com.ali.ark.repository.FundRepository;

@Service
@Component
public class FundService {
	
	@Autowired
	private FundRepository fundRepository;
	
	@Autowired
	private TransactionHistoryService transactionHistoryService;
	
	public String createNewFund(String name) {
		try {
			Fund fund = new Fund(name, 0);
			fund = fundRepository.save(fund);
			return fund.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public boolean fundExists(int fundId) {
		return fundRepository.existsById(Integer.valueOf(fundId));
	}
	
	public String reportFund(int fundId) {
		try {
			Fund fund = fundRepository.findById(Integer.valueOf(fundId)).get();
			return fund.toString();
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting fund from ID " + fundId);
		}
	}
	
	public String reportFunds() {
		try {
			String report = "";
			for(Fund fund: fundRepository.findAll()) {
				report += (fund.toString() + "\n");
			}
			return report;
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting funds from repository");
		}
	}
	
	public String credit(int invId, int fundId, int amount) {
		try {
			Fund fund = fundRepository.findById(Integer.valueOf(fundId)).get();
			transactionHistoryService.addNewTransactionHistory(fundId, invId, amount, TransactionType.CONTRIBUTE.toString());
			fund.setValue(fund.getValue() + amount);
			fund = fundRepository.save(fund);
			return fund.toString();
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting fund from ID " + fundId);
		} catch(Exception e) {
			e.printStackTrace();
			return ("Exception from ID " + fundId + " - View Stack Trace");
		}
	}

	public String debit(int invId, int fundId, int amount) {
		try {
			Fund fund = fundRepository.findById(Integer.valueOf(fundId)).get();
			transactionHistoryService.addNewTransactionHistory(fundId, invId, (amount*-1), TransactionType.EXPENSE.toString());
			fund.setValue(fund.getValue() - amount);
			fund = fundRepository.save(fund);
			return fund.toString();
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting fund from ID " + fundId);
		} catch(Exception e) {
			e.printStackTrace();
			return ("Exception from ID " + fundId + " - View Stack Trace");
		}		
	}

	public String interestFund(int invId, int fundId) {
		try {
			Fund fund = fundRepository.findById(Integer.valueOf(fundId)).get();
			int newValue = (int)(fund.getValue()*1.03);
			transactionHistoryService.addNewTransactionHistory(fundId, invId, ((int)(fund.getValue()*0.03)), TransactionType.INTEREST_INCOME.toString());
			fund.setValue(newValue);
			fund = fundRepository.save(fund);
			return fund.toString();
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting fund from ID " + fundId);
		} catch(Exception e) {
			e.printStackTrace();
			return ("Exception from ID " + fundId + " - View Stack Trace");
		}
	}

	public String chargeFundFee(int invId, int fundId) {
		try {
			Fund fund = fundRepository.findById(Integer.valueOf(fundId)).get();
			int newValue = (int)(fund.getValue()*.98);
			transactionHistoryService.addNewTransactionHistory(fundId, invId, ((int)(fund.getValue()*-0.02)), TransactionType.MANAGEMENT_FEE.toString());
			fund.setValue(newValue);
			fund = fundRepository.save(fund);
			return fund.toString();
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting fund from ID " + fundId);
		} catch(Exception e) {
			e.printStackTrace();
			return ("Exception from ID " + fundId + " - View Stack Trace");
		}
	}

	public String distribute(int invId, int fundId, int newFundId, int amount) {
		try {
			Fund fund = fundRepository.findById(Integer.valueOf(fundId)).get();
			Fund newFund = fundRepository.findById(Integer.valueOf(newFundId)).get();
			fund.setValue(fund.getValue() - amount);
			newFund.setValue(newFund.getValue() + amount);
			transactionHistoryService.addNewTransactionHistory(fundId, invId, (amount*-1), TransactionType.DISTRIBUTION.toString());
			transactionHistoryService.addNewTransactionHistory(newFundId, invId, amount, TransactionType.DISTRIBUTION.toString());
			fund = fundRepository.save(fund);
			newFund = fundRepository.save(newFund);
			return (fund.toString() + "\n" + newFund.toString());
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting fund from IDs " + fundId + ", " + newFundId);
		} catch(Exception e) {
			e.printStackTrace();
			return ("Exception from IDs " + fundId + ", " + newFundId + " - View Stack Trace");
		}
	}

}
