package com.example.parentcontrolservice.cucumber;

import com.example.parentcontrolservice.cucumber.model.TestableParentalControlLevel;
import lombok.Data;

/**
 * Created by raf on 6/07/18.
 */
@Data
public class World {
  TestableParentalControlLevel parentalLevelPreference;
  TestableParentalControlLevel movieParentalLevel;
}
