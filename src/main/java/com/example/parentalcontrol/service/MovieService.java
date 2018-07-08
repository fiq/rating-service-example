package com.example.parentalcontrol.service;

import com.example.parentalcontrol.domain.ParentalControlLevel;
import com.example.parentalcontrol.service.movieservice.TechnicalFailureException;
import com.example.parentalcontrol.service.movieservice.TitleNotFoundException;

/**
 * MovieService provides an asbstraction in front of the upstream
 * MovieService used for obtaining a Movie's Parental Control Level
 */
public interface MovieService {

  /**
   * Returns the parental control level of a Movie
   * as delgated to the MovieService
   * @param movie name
   * @return ParentalControl level
   */
  ParentalControlLevel getParentalControlLevel(String movie)
      throws TitleNotFoundException,TechnicalFailureException;
  
}
