package com.example.parentalcontrol.controller;

import com.example.parentalcontrol.domain.ParentalControlLevel;
import com.example.parentalcontrol.domain.ParentalControlDecision;
import com.example.parentalcontrol.service.MovieFilteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for ParentalControl Service
 */
@RestController
@RequestMapping("/parentalcontrol/movie/{movie}/preference/{level}")
public class ParentalControlController {

  @Autowired
  MovieFilteringService movieFilteringService;

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public ParentalControlDecision getMovieRestrictedByPreference(
      @PathVariable("movie") String movie,
      @PathVariable("level") String parentalControlPreference) {

    // TODO - this needs to be a single responsibility class as opposed to a modifiable map
    ParentalControlLevel preferredLevel = ParentalControlLevel.lookupByRating.get(parentalControlPreference);
    ParentalControlDecision decision = movieFilteringService.getMovieRating(movie, preferredLevel);
    return decision;
  }
}
