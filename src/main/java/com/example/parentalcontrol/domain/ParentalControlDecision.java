package com.example.parentalcontrol.domain;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for parental control decision
 */
@Builder
@Data
public class ParentalControlDecision {
  private String movieParentalControl;
  private String customerParentalControlPreference;
  private Boolean movieIsSuitableForCustomer;
  private String error;
}
