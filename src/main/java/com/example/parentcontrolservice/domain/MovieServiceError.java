package com.example.parentcontrolservice.domain;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for error responses
 */
@Builder
@Data
public class MovieServiceError {
  private String error;
  private String title;
  private Boolean movieIsSuitableForCustomer = false;
}
