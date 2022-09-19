package com.ali.ark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ali.ark.service.FundService;
import com.ali.ark.service.InvestorService;
import com.ali.ark.service.TransactionHistoryService;

@RestController
public class ReportController {

	@Autowired
	private FundService fundService;
	
	@Autowired
	private InvestorService investorService;
	
	@Autowired
	private TransactionHistoryService transactionHistoryService;
	
	@RequestMapping(value = "/report/fund/{fundId}", method = RequestMethod.GET)
	@ResponseBody
	public void reportFund(@PathVariable("fundId") int fundId) {
		if(fundService.fundExists(fundId)) {
			fundService.reportFund(fundId);
		}
	}
	
	@RequestMapping(value = "/report/investor/{invId}", method = RequestMethod.GET)
	@ResponseBody
	public void reportInvestor(@PathVariable("invId") int invId) {
		if(investorService.investorExists(invId)) {
			investorService.reportInvestor(invId);
		}
	}
	
	@RequestMapping(value = "/report/fund", method = RequestMethod.GET)
	@ResponseBody
	public void reportFund() {
		fundService.reportFunds();
	}
	
	@RequestMapping(value = "/report/investor", method = RequestMethod.GET)
	@ResponseBody
	public void reportInvestor() {
		investorService.reportInvestors();
	}
	
	@RequestMapping(value = "/report/transactions", method = RequestMethod.GET)
	@ResponseBody
	public void reportTransactionHistory() {
		transactionHistoryService.reportTransactions();
	}

}