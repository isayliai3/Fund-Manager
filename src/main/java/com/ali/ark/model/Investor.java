package com.ali.ark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVESTOR")
public class Investor {
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	public Investor(String name) {
		this.name=name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "\"Investor\": {\n" + 
				"\t\"ID\": " + this.getId() + "\n" +
				"\t\"Name\": " + this.getName() + "\n" +
				"}";
	}
	
}
