package com.example.sslcommerz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gw {
  public String visa;
  public String master;
  public String amex;
  public String othercards;
  public String internetbanking;
  public String mobilebanking;
}
