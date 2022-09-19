DROP TABLE IF EXISTS FUND;  
CREATE TABLE FUND (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
name VARCHAR(50) NOT NULL,
val INT NOT NULL
);

DROP TABLE IF EXISTS INVESTOR;  
CREATE TABLE INVESTOR (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
name VARCHAR(50) NOT NULL,
); 

DROP TABLE IF EXISTS TRANSACTION_HISTORY;  
CREATE TABLE TRANSACTION_HISTORY (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
fundId INT NOT NULL,
investorId INT NOT NULL,
amount INT NOT NULL,
transactionType VARCHAR(50) NOT NULL
); 