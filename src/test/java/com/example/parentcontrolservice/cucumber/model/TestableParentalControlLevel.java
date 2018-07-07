package com.example.parentcontrolservice.cucumber.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.Map;

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

  // TODO: clear this up - used to handle integer ratings as I can't use in them in
  // enum.name or valueOf
  public static Map<String, TestableParentalControlLevel> lookupByRating = new HashMap<>();
  static {
    Lists.newArrayList(TestableParentalControlLevel.values()).stream().forEach(item -> {
      lookupByRating.put(item.getParentalControlLevel(), item);
    });
  }

  @Getter
  private String parentalControlLevel;

  @Getter
  private String description;
}
