package com.example.parentcontrolservice.service;

import com.example.parentcontrolservice.domain.ParentalControlDecision;
import com.example.parentcontrolservice.domain.ParentalControlLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Concrete implementation of the movie filtering service
 */
@Service
public class MovieFilteringServiceImpl implements MovieFilteringService {

  @Autowired
  private MovieService movieService;

  /**
   * Makes a decision using business rules to decide if a movie should be viewable
   * based on parental control preferences
   * @param movie name
   * @param parentalControlPreference of the customer
   * @return a ParentalControlDecsion
   */
  @Override
  public ParentalControlDecision getMovieRating(String movie, ParentalControlLevel parentalControlPreference) {

    ParentalControlLevel movieParentalControl = null;
    movieParentalControl = movieService.getParentalControlLevel(movie);

    String preferenceLevel = parentalControlPreference.getParentalControlLevel();
    String movieLevel = movieParentalControl.getParentalControlLevel();

    boolean movieIsSuitableForCustomer = parentalControlPreference.getPriority() >= movieParentalControl.getPriority();
    ParentalControlDecision decision = ParentalControlDecision.builder()
        .customerParentalControlPreference(preferenceLevel)
        .movieParentalControl(movieLevel)
        .movieIsSuitableForCustomer(movieIsSuitableForCustomer)
        .build();

    return decision;
  }
}
