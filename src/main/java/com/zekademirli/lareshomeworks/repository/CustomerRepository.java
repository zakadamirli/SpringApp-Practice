package com.zekademirli.lareshomeworks.repository;

import com.zekademirli.lareshomeworks.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
