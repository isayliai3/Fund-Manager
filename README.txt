Navigate to the "fundmanager" directory that was cloned from the repository.

RUN OPTION 1:
	In command line, run:
		mvn package
	From the current directory location, with the JAR file created in the "target" directory, run command:
		java -jar target/fundmanager-0.0.1-SNAPSHOT.jar

RUN OPTION 2:
	In command line, run:
		mvn spring-boot:run

API Calls:

	Create Fund:
		curl -v http://localhost:8080/fund/{Name}

	Create Investor:
		curl -v http://localhost:8080/investor/{Name}

	Contribute To Fund:
		curl -i \
		-H "Accept: application/json" \
		-H "Content-Type:application/json" \
		-X PUT --data
  		'{"investorId": "{Investor ID}", "fundId": "{Fund ID}", "amount": "{Amount}"}' "http://localhost:8080/fund/contribute"

	Expense From Fund:
		curl -i \
		-H "Accept: application/json" \
		-H "Content-Type:application/json" \
		-X PUT --data
  		'{"investorId": "{Investor ID}", "fundId": "{Fund ID}", "amount": "{Amount}"}' "http://localhost:8080/fund/expense"

	Income Interest To Fund:
		curl -i \
		-H "Accept: application/json" \
		-H "Content-Type:application/json" \
		-X PUT --data
  		'{"investorId": "{Investor ID}", "fundId": "{Fund ID}", "amount": "null"}' "http://localhost:8080/fund/interest"

	Charge Fund Fee:
		curl -i \
		-H "Accept: application/json" \
		-H "Content-Type:application/json" \
		-X PUT --data
  		'{"investorId": "{Investor ID}", "fundId": "{Fund ID}", "amount": "null"}' "http://localhost:8080/fund/fee"

	Distribute From Fund To Another:
		curl -i \
		-H "Accept: application/json" \
		-H "Content-Type:application/json" \
		-X PUT --data
  		'{"investorId": "{Investor ID}", "fundId": "{Fund ID}", "amount": "{Amount}"}' "http://localhost:8080/fund/distribute/{NewFundId}"

	Report Individual Fund:
		curl -v http://localhost:8080/report/fund/{FundId}

	Report All Funds:
		curl -v http://localhost:8080/report/fund

	Report Individual Investor:
		curl -v http://localhost:8080/report/investor/{InvestorId}

	Report All Investors:
		curl -v http://localhost:8080/report/investor

	Report All Transactions:
		curl -v http://localhost:8080/report/transactions
