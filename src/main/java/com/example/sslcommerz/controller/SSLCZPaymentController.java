package com.example.sslcommerz.controller;

import com.example.sslcommerz.model.SSLCommerzValidatorResponse;
import com.example.sslcommerz.repository.SSLCZPaymentRepository;
import com.example.sslcommerz.service.TransactionInitiator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class SSLCZPaymentController {

    private final SSLCZPaymentRepository sslczPaymentRepository;

    @PostMapping("/initiate-payment")
    public String initiatePayment() {
        return null;
    }

//    @GetMapping("/initiate")
//    public String initiatePayment1() {
//        TransactionInitiator transactionInitiator = new TransactionInitiator();
//        String response = transactionInitiator.initTrnxnRequest();
//        return response;
//    }

    @PostMapping("/success")
    public String successMessage() {
        return "Success";
    }

    @GetMapping("/initiate")
    public String initiatePayment(
            @RequestParam String amount,
            String tran_id,
            String cus_email,
            String cus_name,
            SSLCommerzValidatorResponse sslCommerzValidatorResponse
    ) {
        TransactionInitiator initiator = new TransactionInitiator();
        String response = initiator.initTrnxnRequest(
                amount,
                tran_id,
                cus_name,
                cus_email
        );
        sslCommerzValidatorResponse.setAmount(amount);
        sslCommerzValidatorResponse.setTran_id(tran_id);
        sslczPaymentRepository.save(sslCommerzValidatorResponse);
        return response;
    }
}