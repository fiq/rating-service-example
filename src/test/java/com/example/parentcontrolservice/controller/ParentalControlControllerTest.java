package com.example.parentcontrolservice.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
  public void itShouldValidateIfAMovieIsNotViewable() {
  }

}