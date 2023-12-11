package com.example.sslcommerz.controller;

import com.example.sslcommerz.model.SSLCommerzValidatorResponse;
import com.example.sslcommerz.repository.SSLCZPaymentRepository;
import com.example.sslcommerz.service.SSLCZPaymentService;
import com.example.sslcommerz.service.TransactionInitiator;
import com.example.sslcommerz.service.TransactionResponseValidator;
import com.example.sslcommerz.util.RandomTransactionId;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class SSLCZPaymentController {

  private final SSLCZPaymentRepository sslczPaymentRepository;
  private final SSLCZPaymentService sslczPaymentService;
//  private final TransactionResponseValidator responseValidator;

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
//            String tran_id,
      String cus_email,
      String cus_name,
      SSLCommerzValidatorResponse sslCommerzValidatorResponse
  ) {
//        String uniqeNum= String.valueOf((int) (Math.random()* 100000000));
//        String tran_id="TX"+uniqeNum;
    String tran_id = RandomTransactionId.randomTransactionId();
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


  @GetMapping("/{transactionId}")
  public String checkTransaction(@PathVariable String transactionId) throws Exception {
    sslczPaymentService.checkTransaction(transactionId);
    if (false) {
      return "redirect:http://localhost:8080/payment/initiate";
    } else {
      return "Success";
    }
  }

  @GetMapping("/validate-payment")
  public boolean validatePayment(@RequestParam Map<String, String> queryParams) throws Exception {
//    try {
      TransactionResponseValidator responseValidator = new TransactionResponseValidator();
      return responseValidator.receiveSuccessResponse(queryParams);
//      return isSuccess ? "Payment successful" : "Payment failed or canceled";
//    } catch (Exception e) {
//      return "Error validating payment: " + e.getMessage();
//    }
//    return null;
  }
}