package com.example.parentcontrolservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by raf on 7/07/18.
 */
@Data
@AllArgsConstructor
public class ParentalControlResponse {
  private String parentalControlLevel;
  private String error;
}
