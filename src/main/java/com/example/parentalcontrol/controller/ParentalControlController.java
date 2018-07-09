package com.example.parentalcontrol.controller;

import com.example.parentalcontrol.domain.ParentalControlDecision;
import com.example.parentalcontrol.domain.ParentalControlLevel;
import com.example.parentalcontrol.service.MovieFilteringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for ParentalControl Service
 */
@Api(
    value="Parental Control Service API",
    description = "Provides parental Control based decisions on movie viewability")
@RestController
@RequestMapping("/parentalcontrol/movie/{movie}/preference/{level}")
public class ParentalControlController {

  // TODO I prefer constructor injection, but find field level DI convenient when discovering APIs
  @Autowired
  private MovieFilteringService movieFilteringService;

  @ApiOperation(value="Validates whether a movie is viewable, given the customer parental control preferences",
      response = ParentalControlDecision.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Payload with the decision"),
      @ApiResponse(code=404, message = "The movie is not known"),
      @ApiResponse(code=500, message = "There was a technical difficulty")
  })
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
