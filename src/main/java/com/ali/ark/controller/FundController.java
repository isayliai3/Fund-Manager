package com.ali.ark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ali.ark.fundmanager.Transaction;
import com.ali.ark.service.FundService;
import com.ali.ark.service.InvestorService;

@RestController
public class FundController {

	@Autowired
	private FundService fundService;
	
	@Autowired
	private InvestorService investorService;
	
	@RequestMapping(value = "/fund/{name}", method = RequestMethod.POST)
	@ResponseBody
	public void createFund(@PathVariable("name") String name) {
		fundService.createNewFund(name);
	}
	
	@RequestMapping(value = "/fund/contribute", method = RequestMethod.PUT)
	@ResponseBody
	public void creditFund(@RequestBody Transaction transaction) {
		int invId = transaction.getInvestorId();
		int fundId = transaction.getFundId();
		int amount = transaction.getAmount();
		if(investorService.investorExists(invId) && fundService.fundExists(fundId)) {
			fundService.credit(invId, fundId, amount);
		}
	}
	
	@RequestMapping(value = "/fund/expense", method = RequestMethod.PUT)
	@ResponseBody
	public void debitFund(@RequestBody Transaction transaction) {
		int invId = transaction.getInvestorId();
		int fundId = transaction.getFundId();
		int amount = transaction.getAmount();
		if(investorService.investorExists(invId) && fundService.fundExists(fundId)) {
			fundService.debit(invId, fundId, amount);
		}
	}
	
	@RequestMapping(value = "/fund/interest", method = RequestMethod.PUT)
	@ResponseBody
	public void interestFund(@RequestBody Transaction transaction) {
		int invId = transaction.getInvestorId();
		int fundId = transaction.getFundId();
		if(investorService.investorExists(invId) && fundService.fundExists(fundId)) {
			fundService.interestFund(invId, fundId);
		}
	}
	
	@RequestMapping(value = "/fund/fee", method = RequestMethod.PUT)
	@ResponseBody
	public void chargeFundFee(@RequestBody Transaction transaction) {
		int invId = transaction.getInvestorId();
		int fundId = transaction.getFundId();
		if(investorService.investorExists(invId) && fundService.fundExists(fundId)) {
			fundService.chargeFundFee(invId, fundId);
		}
	}
	
	@RequestMapping(value = "/fund/distribute/{newFundId}", method = RequestMethod.PUT)
	@ResponseBody
	public void distributeFunds(@RequestBody Transaction transaction,
			@PathVariable("newFundId") int newFundId) {
		int invId = transaction.getInvestorId();
		int fundId = transaction.getFundId();
		int amount = transaction.getAmount();
		if(investorService.investorExists(invId) 
				&& fundService.fundExists(fundId)
				&& fundService.fundExists(newFundId)) {
			fundService.distribute(invId, fundId, newFundId, amount);
		}
	}
}