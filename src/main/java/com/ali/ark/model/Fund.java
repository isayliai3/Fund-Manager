package com.ali.ark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FUND")
public class Fund {
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private int val;
	
	public Fund(String name, int value) {
		this.name=name;
		this.val=value;
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
	public int getValue() {
		return val;
	}
	public void setValue(int value) {
		this.val = value;
	}
	
	public String toString() {
		return "\"Fund\": {\n" + 
				"\t\"ID\": " + this.getId() + "\n" +
				"\t\"Name\": " + this.getName() + "\n" +
				"\t\"Value\": " + this.getValue() + "\n" +
				"}";
	}
	
}
