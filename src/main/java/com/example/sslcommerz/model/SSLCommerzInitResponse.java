package com.example.sslcommerz.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SSLCommerzInitResponse {
  public String status;
  public String failedreason;
  public String sessionkey;
  public Gw gw;
  public String redirectGatewayURL;
  public String redirectGatewayURLFailed;
  public String GatewayPageURL;
  public String storeBanner;
  public String storeLogo;
  public List<Desc> desc;
  public String is_direct_pay_enable;
}
