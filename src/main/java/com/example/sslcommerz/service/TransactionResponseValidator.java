package com.example.sslcommerz.service;

import java.util.Map;

/**
 * This class handles the Response parameters redirected from payment success page.
 * Validates those parameters fetched from payment page response and returns true for successful transaction
 * and false otherwise.
 */
public class TransactionResponseValidator {
    /**
     *
     * @param request
     * @return
     * @throws Exception
     * Send Received params from your success resoponse (POST ) in this Map</>
     */
    public boolean receiveSuccessResponse(Map<String, String> request) throws Exception {

        String trxId = request.get("tran_id");
//        String trxId = "TX20551534";
        /**
         *Get your AMOUNT and Currency FROM DB to initiate this Transaction
         */
        String amount = "1000";
        String currency = "BDT";
        // Set your store Id and store password and define TestMode
        SSLCommerz sslcz = new SSLCommerz("test6570a70548410", "test6570a70548410", true);

        /**
         * If following order validation returns true, then process transaction as success.
         * if this following validation returns false , then query status if failed of canceled.
         *      Check request.get("status") for this purpose
         */
//        return sslcz.orderValidate(trxId, amount, currency, request);
        return sslcz.orderValidate(trxId, "1000", "BDT", request);

    }
}
