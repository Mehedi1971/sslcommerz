package com.example.sslcommerz.controller;

import com.example.sslcommerz.service.SSLCZPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class SSLCZPaymentController {

  private final SSLCZPaymentService sslczPaymentService;

  @PostMapping("/initiate-payment")
  public String initiatePayment() {
    return null;
  }
}
