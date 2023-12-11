package com.example.sslcommerz.util;

public class RandomTransactionId {
  public static String randomTransactionId(){
    String uniqeNum= String.valueOf((int) (Math.random()* 100000000));
    String tran_id="TX"+uniqeNum;
    return tran_id;
  }

}
