package com.ali.ark.service;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ali.ark.model.Investor;
import com.ali.ark.repository.InvestorRepository;

@Service
@Component
public class InvestorService {
	
	@Autowired
	private InvestorRepository investorRepository;
	
	public String createNewInvestor(String name) {
		try {
			Investor investor = new Investor(name);
			investor = investorRepository.save(investor);
			return investor.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public boolean investorExists(int invId) {
		return investorRepository.existsById(Integer.valueOf(invId));
	}
	
	public String reportInvestor(int invId) {
		try {
			Investor investor = investorRepository.findById(Integer.valueOf(invId)).get();
			return investor.toString();
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting investor from ID " + invId);
		}
	}
	
	public String reportInvestors() {
		try {
			String report = "";
			for(Investor investor: investorRepository.findAll()) {
				report += (investor.toString() + "\n");
			}
			return report;
		} catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			return ("Exception getting investors from repository");
		}
	}
}
