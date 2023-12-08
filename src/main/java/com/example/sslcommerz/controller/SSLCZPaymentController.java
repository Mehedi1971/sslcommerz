package com.example.sslcommerz.controller;

import com.example.sslcommerz.service.TransactionInitiator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class SSLCZPaymentController {

//  private final SSLCZPaymentService sslczPaymentService;

  @PostMapping("/initiate-payment")
  public String initiatePayment() {
    return null;
  }

  @GetMapping("/initiate")
  public String initiatePayment1() {
    TransactionInitiator transactionInitiator = new TransactionInitiator();

    // Call the initTrnxnRequest method to initiate the transaction
    String response = transactionInitiator.initTrnxnRequest();

    // You can now send the response back to the client or process it further
    // For example, you might redirect the client to the SSL Commerz payment page
    // or return the response as JSON to the client
    return response;
  }

  @GetMapping("/success")
  public String successMessage(){
    return "Success";
  }
}
