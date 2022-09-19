package com.ali.ark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ali.ark.service.InvestorService;

@RestController
public class InvestorController {
	
	@Autowired
	private InvestorService investorService;
	
	@RequestMapping(value = "/investor/{name}", method = RequestMethod.POST)
	@ResponseBody
	public void createInvestor(@PathVariable("name") String name) {
		investorService.createNewInvestor(name);
	}

}