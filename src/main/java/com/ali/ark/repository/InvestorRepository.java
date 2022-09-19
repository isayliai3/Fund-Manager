package com.ali.ark.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ali.ark.model.Investor; 

@Repository
public interface InvestorRepository extends CrudRepository<Investor, Integer> {

}
