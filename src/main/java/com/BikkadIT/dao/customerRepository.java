package com.BikkadIT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.model.customer;

@Repository
public interface customerRepository extends JpaRepository<customer, Integer> {

}
