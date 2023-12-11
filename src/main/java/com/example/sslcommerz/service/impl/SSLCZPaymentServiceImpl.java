package com.example.sslcommerz.service.impl;

import com.example.sslcommerz.service.SSLCZPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SSLCZPaymentServiceImpl implements SSLCZPaymentService {

  public boolean checkTransaction(String transactionId) throws Exception {
    String requestedUrl =
        "https://sandbox.sslcommerz.com/validator/api/merchantTransIDvalidationAPI.php"
            + "?tran_id=" + transactionId + "&store_id=" + "test6570a70548410" + "&store_passwd="
            + "test6570a70548410@ssl" + "&v=1&format=json";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(requestedUrl, String.class);
    System.out.println(responseEntity.getBody().contains("\"status\":\"VALID\""));
    boolean exits = responseEntity.getBody().contains("\"status\":\"VALIDATED\"");
//    boolean exits = responseEntity.getBody().contains("\"APIConnect\":\"DONE\"");
    System.out.println(exits);
    if (exits) {
      return true;
    }
    return false;
  }

}
//  public boolean checkTransaction(String transactionId) throws Exception {
//    String requestedUrl =
//        "https://sandbox.sslcommerz.com/validator/api/merchantTransIDvalidationAPI.php" +
//            "?tran_id=" + transactionId +
//            "&store_id=" + "test6570a70548410" +
//            "&store_passwd=" + "test6570a70548410@ssl" +
//            "&v=1&format=json";
//
//    RestTemplate restTemplate = new RestTemplate();
//    ResponseEntity<String> responseEntity = restTemplate.getForEntity(requestedUrl, String.class);
//    System.out.println(responseEntity.getBody().contains("\"status\":\"FAILED"));
//    boolean exits = responseEntity.getBody().contains("\"status\":\"FAILED");
//    if (exits) {
//      return true;
////      String response = "";
////      String tran_id = RandomTransactionId.randomTransactionId();
////      response=TransactionInitiator.initTrnxnRequest("1000",tran_id,"Mahedi","mahedi@gmail.com");
////      return response;
////      return new ModelAndView(
////
////          "redirect:https://localhost:8080/payment/initiate");
//    }
////    if (responseEntity.getStatusCode().is2xxSuccessful()) {
////      return "Transaction validation successful";
////    } else {
////      return "No Record Found";
////    }
////  }
////    else {
////
////    }
//
////}
//// return null;
//    return false;
//  }
//}
