package com.example.parentcontrolservice.domain;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Levels for different parental controls
 */
@AllArgsConstructor
public enum ParentalControlLevel {
  U ("U", 1),
  PG ("PG", 2),
  TWELVE ("12", 3),
  FIFTEEN ("15", 4),
  EIGHTEEN ("18", 5);

  // TODO: clear this up - used to handle integer ratings as I can't use in them in
  // enum.name or valueOf
  public static Map<String, ParentalControlLevel> lookupByRating = new ConcurrentHashMap<>();
  static {
    Lists.newArrayList(ParentalControlLevel.values()).stream().forEach(item ->
      lookupByRating.put(item.getParentalControlLevel(), item)
    );
  }

  @Getter
  private String parentalControlLevel;

  @Getter
  private Integer priority;
}
