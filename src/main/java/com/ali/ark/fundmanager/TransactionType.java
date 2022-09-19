package com.ali.ark.fundmanager;

public enum TransactionType {
	CONTRIBUTE("Contribute"),
	EXPENSE("General Expense"),
	INTEREST_INCOME("Interest Income"),
	MANAGEMENT_FEE("Management Fee"),
	DISTRIBUTION("Distribution")
	;
	
	private final String type;
	
	TransactionType(String type) {
		this.type = type;
	}
	
	public String toString() {
        return type;
    }
}