package com.ali.ark.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ali.ark.model.Fund; 

@Repository
public interface FundRepository extends CrudRepository<Fund, Integer> {

}
