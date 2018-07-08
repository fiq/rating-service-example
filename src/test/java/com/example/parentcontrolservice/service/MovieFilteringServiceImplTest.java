package com.example.parentcontrolservice.service;

import com.example.parentcontrolservice.domain.ParentalControlDecision;
import com.example.parentcontrolservice.domain.ParentalControlLevel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
  public void itShouldNotPermitACustomerWithUniversalPreferenceToWatchAn18() {
    ParentalControlLevel preferenceLevel = ParentalControlLevel.U;
    ParentalControlLevel movieLevel = ParentalControlLevel.EIGHTEEN;
    String movie = "The Holy Grail";
    viewingShouldBeDenied(preferenceLevel, movieLevel, movie);
  }

  @Test
  public void itShouldPermitACustomerToViewAMovieAtTheSamePreferenceLevel(){
    ParentalControlLevel preferenceLevel = ParentalControlLevel.U;
    ParentalControlLevel movieLevel = ParentalControlLevel.U;
    String movie = "Bambi";
    viewingShouldBePermitted(preferenceLevel, movieLevel, movie);
  }

  @Test
  public void itShouldNotPermitACustomerToViewAMovieAtAHigherControlLevel(){
    String movie = "Bambi";

    // Non-deterministic values from the enum are sorted by priority
    List<ParentalControlLevel> parentalControlLevels = Arrays.stream(ParentalControlLevel.values())
        .sorted(Comparator.comparing(ParentalControlLevel::getPriority).reversed())
        .collect(Collectors.toList());

    // Remove the first element and compare to the rest
    ParentalControlLevel preferenceLevel = parentalControlLevels.remove(0);

    parentalControlLevels.stream().forEach(movieLevel -> {
      viewingShouldBePermitted(preferenceLevel, movieLevel, movie);
    });
  }

  @Test
  public void itShouldPermitACustomerToViewAMovieAtALowerControlLevel(){
    ParentalControlLevel preferenceLevel = ParentalControlLevel.EIGHTEEN;
    ParentalControlLevel movieLevel = ParentalControlLevel.U;
    String movie = "Bambi";
    viewingShouldBePermitted(preferenceLevel, movieLevel, movie);
  }

  // TODO codesmells: too many params and uncle-bob doesn't like boolean arguments
  private void viewingShouldBePermitted(ParentalControlLevel preferenceLevel, ParentalControlLevel movieLevel, String movie) {
    testParentalControlDecision(preferenceLevel, movieLevel, movie, true);
  }

  private void viewingShouldBeDenied(ParentalControlLevel preferenceLevel, ParentalControlLevel movieLevel, String movie) {
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
}