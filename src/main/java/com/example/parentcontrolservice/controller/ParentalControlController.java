package com.example.parentcontrolservice.controller;

import com.example.parentcontrolservice.domain.ParentalControlResponse;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for ParentalControl Service
 */
@RestController
@RequestMapping("/parentalcontrol/movie/{movie}/preference/{level}")
public class ParentalControlController {

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public ParentalControlResponse getMovieRestrictedByPreference(
      @PathVariable("movie") String movie,
      @PathVariable("level") String parentalControlPreference) {
    return new ParentalControlResponse("WIP", null);
  }
}
