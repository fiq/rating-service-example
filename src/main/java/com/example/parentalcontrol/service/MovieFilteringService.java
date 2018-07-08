package com.example.parentalcontrol.service;

import com.example.parentalcontrol.domain.ParentalControlDecision;
import com.example.parentalcontrol.domain.ParentalControlLevel;
import org.springframework.stereotype.Service;

/**
 * Service for returning the parental control level of a movie if it is viewable to someone with the preference
 */
@Service
public interface MovieFilteringService {

  ParentalControlDecision getMovieRating(String movie, ParentalControlLevel parentalControlPreference);
  
}
