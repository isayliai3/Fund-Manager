package com.ali.ark.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ali.ark.model.TransactionHistory; 

@Repository
public interface TransactionHistoryRepository extends CrudRepository<TransactionHistory, Integer> {

}
