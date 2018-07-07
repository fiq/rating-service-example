package com.example.parentcontrolservice.controller;

import com.example.parentcontrolservice.cucumber.model.APIShape;
import com.example.parentcontrolservice.cucumber.model.TestableParentalControlLevel;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests the ParentalControlController
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class ParentalControlControllerTest {
  @Autowired
  MockMvc mockMvc;

  @Test
  @Ignore("TODO - confirm is this is a requirement")
  public void itShouldProvideAListOfAllParentalControlRatings() {
  }

  @Test
  @Ignore("TODO - implement")
  public void itShouldValidateIfAMovieIsViewable() {
  }

  @Test
  public void itShouldNotPermitAChildToWatchARated18Movie() throws Exception {
    TestableParentalControlLevel preferenceLevel = TestableParentalControlLevel.U;
    TestableParentalControlLevel movieLevel = TestableParentalControlLevel.EIGHTEEN;
    String path = APIShape.serviceUrlFor("Jaws", preferenceLevel);

    mockMvc.perform(get(path))
        .andExpect(jsonPath("$.parentalControlLevel", is(false)))
        .andExpect(status().isOk());
  }
}