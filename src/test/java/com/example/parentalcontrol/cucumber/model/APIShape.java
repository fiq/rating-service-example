package com.example.parentalcontrol.cucumber.model;

/**
 * Constants describing the shape of the API for testing purposes
 */
public class APIShape {
  // TODO is not RESTful - change to either RPC style or provide filters of movie and preference
  private static final String SERVICE_REQUEST_TEMPLATE = "/parentalcontrol/movie/%s/preference/%s";

  /**
   * Json Query for parental control decision result
   */
  public static final String PARENTAL_CONTROL_QUERY = "$.movieIsSuitableForCustomer";

  public static String serviceUrlFor(String movie, TestableParentalControlLevel preferenceLevel) {
    return String.format(SERVICE_REQUEST_TEMPLATE, movie, preferenceLevel.getParentalControlLevel());
  }
}
