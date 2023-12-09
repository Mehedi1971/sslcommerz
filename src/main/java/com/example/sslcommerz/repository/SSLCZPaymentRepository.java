package com.example.sslcommerz.repository;

import com.example.sslcommerz.model.SSLCommerzValidatorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSLCZPaymentRepository extends JpaRepository<SSLCommerzValidatorResponse,Long> {

}
