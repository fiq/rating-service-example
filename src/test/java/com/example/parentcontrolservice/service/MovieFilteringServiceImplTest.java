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
    ParentalControlLevel preference = ParentalControlLevel.U;
    ParentalControlLevel movieParentalControlLevel = ParentalControlLevel.EIGHTEEN;
    String movie = "The Holy Grail";
    when(movieService.getParentalControlLevel(movie)).thenReturn(movieParentalControlLevel);

    ParentalControlDecision decision =
        underTest.getMovieRating(movie, preference);

    // decision
    assertThat(decision.getMovieIsSuitableForCustomer(), is(false));

    // identity tests
    assertThat(decision.getMovieParentalControl(),is("18"));
    assertThat(decision.getCustomerParentalControlPreference(),is("U"));
  }
}