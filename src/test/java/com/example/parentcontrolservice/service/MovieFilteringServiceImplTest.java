package com.example.parentcontrolservice.service;

import com.example.parentcontrolservice.domain.ParentalControlDecision;
import com.example.parentcontrolservice.domain.ParentalControlLevel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Tests the service responsible for indicating if a movie should be viewable
 * based on customer parental control preferences
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieFilteringServiceImplTest {

  @Mock
  MovieService movieService;

  @InjectMocks
  MovieFilteringServiceImpl underTest;

  @Test
  public void itShouldNotPermitAnUniversalPreferenceToWatchAn18() {
    ParentalControlLevel preferenceLevel = ParentalControlLevel.U;
    ParentalControlLevel movieLevel = ParentalControlLevel.EIGHTEEN;
    String movie = "The Holy Grail";
    testViewingDenied(preferenceLevel, movieLevel, movie);
  }


  // TODO codesmells: too many params and uncle-bob doesn't like boolean arguments
  private void testViewingDenied(ParentalControlLevel preferenceLevel, ParentalControlLevel movieLevel, String movie) {
    testParentalControlDecision(preferenceLevel, movieLevel, movie, false);
  }

  private void testParentalControlDecision(ParentalControlLevel preference, ParentalControlLevel movieParentalControlLevel, String movie, Boolean expectedToBeViewable) {
    when(movieService.getParentalControlLevel(movie)).thenReturn(movieParentalControlLevel);
    ParentalControlDecision decision =
        underTest.getMovieRating(movie, preference);

    // test decision
    assertThat(decision.getMovieIsSuitableForCustomer(), is(expectedToBeViewable));

    // Test contextual data
    String expectedMovieLevel = movieParentalControlLevel.getParentalControlLevel();
    String expectedPreferenceLevel = preference.getParentalControlLevel();
    assertThat(decision.getMovieParentalControl(),is(expectedMovieLevel));
    assertThat(decision.getCustomerParentalControlPreference(),is(expectedPreferenceLevel));
  }

  public void itShouldPermitViewingOfAMovieAtTheSamePreferenceLevel(){

  }

}