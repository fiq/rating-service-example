package com.example.parentcontrolservice.service;

import com.example.parentcontrolservice.domain.ParentalControlDecision;
import com.example.parentcontrolservice.domain.ParentalControlLevel;
import org.springframework.stereotype.Service;

/**
 * Service for returning the parental control level of a movie if it is viewable to someone with the preference
 */
@Service
public interface MovieFilteringService {

  ParentalControlDecision getMovieRating(String movie, ParentalControlLevel parentalControlPreference);
  
}
