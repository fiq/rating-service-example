package com.example.parentcontrolservice.cucumber;

import com.example.parentcontrolservice.cucumber.model.TestableParentalControlLevel;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.ResultActions;

/**
 * Created by raf on 6/07/18.
 */
@Data
@Component
public class World {
  TestableParentalControlLevel parentalLevelPreference;
  TestableParentalControlLevel movieParentalLevel;
  ResultActions response;
}
