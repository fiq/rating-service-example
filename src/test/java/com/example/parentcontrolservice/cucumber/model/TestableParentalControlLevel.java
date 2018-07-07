package com.example.parentcontrolservice.cucumber.model;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * An outside in test specific enumeration of
 * ParentalControl Levels which are independent of
 * the actual implementation and represent our acceptance criteria
 */
@AllArgsConstructor
public enum TestableParentalControlLevel {
  U ("U", "Universal"),
  PG ("PG", "Parental Guidance"),
  TWELVE ("12", "Rated 12"),
  FIFTEEN ("15", "Rated 15"),
  EIGHTEEN ("18", "Rated 18");

  @Getter
  private String parentalControlLevel;

  @Getter
  private String description;
}
