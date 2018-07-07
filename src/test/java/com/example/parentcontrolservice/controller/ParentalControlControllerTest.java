package com.example.parentcontrolservice.controller;

import com.example.parentcontrolservice.cucumber.model.APIShape;
import com.example.parentcontrolservice.cucumber.model.TestableParentalControlLevel;
import com.example.parentcontrolservice.domain.ParentalControlDecision;
import com.example.parentcontrolservice.domain.ParentalControlLevel;
import com.example.parentcontrolservice.service.MovieFilteringService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.parentcontrolservice.cucumber.model.APIShape.PARENTAL_CONTROL_QUERY;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests the ParentalControlController
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ParentalControlController.class)
public class ParentalControlControllerTest {
  public static final String JAWS = "Jaws";
  @MockBean
  MovieFilteringService movieFilteringService;

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
  public void itShouldNotPermitAChildToWatchAn18RatedMovie() throws Exception {
    // Intended to keep test 'assumptions' about correct behaviour clear
    TestableParentalControlLevel preferenceLevel = TestableParentalControlLevel.U;
    TestableParentalControlLevel movieLevel = TestableParentalControlLevel.EIGHTEEN;
    String path = APIShape.serviceUrlFor(JAWS, preferenceLevel);

    // using declarative builder pattern
    ParentalControlDecision decision = ParentalControlDecision.builder()
        .customerParentalControlPreference(preferenceLevel.getParentalControlLevel())
        .movieParentalControl(movieLevel.getParentalControlLevel())
        .movieIsSuitableForCustomer(false)
        .build();

    ParentalControlLevel customerPreference =
        ParentalControlLevel.lookupByRating.get( preferenceLevel.getParentalControlLevel() );

    when(movieFilteringService.getMovieRating(JAWS, customerPreference))
        .thenReturn(decision);

    mockMvc.perform(get(path))
        .andExpect(jsonPath(PARENTAL_CONTROL_QUERY, is(false)))
        .andExpect(status().isOk());
  }
}