package com.example.sslcommerz.Utility;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ParameterBuilder {
    public static String getParamsString(Map<String, String> params, boolean urlEncode) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (urlEncode)
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            else
                result.append(entry.getKey());

            result.append("=");
            if (urlEncode)
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            else
                result.append(entry.getValue());
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

//    public static Map<String, String> constructRequestParameters() {
//        // CREATING LIST OF POST DATA
//        String baseUrl = "http://localhost:8080/";//Request.Url.Scheme + "://" + Request.Url.Authority + Request.ApplicationPath.TrimEnd('/') + "/";
//        Map<String, String> postData = new HashMap<String, String>();
//        postData.put("total_amount", "15000.00");
//        postData.put("tran_id", "TESTASPNET1234");
//        postData.put("success_url", baseUrl + "payment/success");
//        postData.put("fail_url", "https://sandbox.sslcommerz.com/developer/fail.php");
//        postData.put("cancel_url", "https://sandbox.sslcommerz.com/developer/cancel.php");
//        postData.put("version", "3.00");
//        postData.put("cus_name", "ABC XY");
//        postData.put("cus_email", "abc.xyz@mail.co");
//        postData.put("cus_add1", "Address Line On");
//        postData.put("cus_add2", "Address Line Tw");
//        postData.put("cus_city", "City Nam");
//        postData.put("cus_state", "State Nam");
//        postData.put("cus_postcode", "Post Cod");
//        postData.put("cus_country", "Countr");
//        postData.put("cus_phone", "0111111111");
//        postData.put("cus_fax", "0171111111");
//        postData.put("ship_name", "ABC XY");
//        postData.put("ship_add1", "Address Line On");
//        postData.put("ship_add2", "Address Line Tw");
//        postData.put("ship_city", "City Nam");
//        postData.put("ship_state", "State Nam");
//        postData.put("ship_postcode", "Post Cod");
//        postData.put("ship_country", "Countr");
//        postData.put("value_a", "ref00");
//        postData.put("value_b", "ref00");
//        postData.put("value_c", "ref00");
//        postData.put("value_d", "ref00");
//        return postData;
//    }

    public static Map<String, String> constructRequestParameters(
            String dynamicAmount,
            String dynamicTranId,
            String success_url,
            String fail_url,
            String cancel_url,
            String version,
            String cus_name,
            String cus_email,
            String cus_add1,
            String cus_add2,
            String cus_city,
            String cus_state,
            String cus_postcode,
            String cus_country,
            String cus_phone,
            String cus_fax,
            String ship_name,
            String ship_add1,
            String ship_add2,
            String ship_city,
            String ship_state,
            String ship_postcode,
            String ship_country,
            String value_a,
            String value_b,
            String value_c,
            String value_d
    ) {
        String baseUrl = "http://localhost:8080/";
        Map<String, String> postData = new HashMap<>();
        postData.put("total_amount", dynamicAmount);
        postData.put("tran_id", dynamicTranId);
        postData.put("success_url", success_url);
        postData.put("fail_url", fail_url);
        postData.put("cancel_url", cancel_url);
        postData.put("version", version);
        postData.put("cus_name", cus_name);
        postData.put("cus_email", cus_email);
        postData.put("cus_add1", cus_add1);
        postData.put("cus_add2", cus_add2);
        postData.put("cus_city", cus_city);
        postData.put("cus_state", cus_state);
        postData.put("cus_postcode", cus_postcode);
        postData.put("cus_country", cus_country);
        postData.put("cus_phone", cus_phone);
        postData.put("cus_fax", cus_fax);
        postData.put("ship_name", ship_name);
        postData.put("ship_add1", ship_add1);
        postData.put("ship_add2", ship_add2);
        postData.put("ship_city", ship_city);
        postData.put("ship_state", ship_state);
        postData.put("ship_postcode", ship_postcode);
        postData.put("ship_country", ship_country);
        postData.put("value_a", value_a);
        postData.put("value_b", value_b);
        postData.put("value_c", value_c);
        postData.put("value_d", value_d);
        return postData;
    }
}
