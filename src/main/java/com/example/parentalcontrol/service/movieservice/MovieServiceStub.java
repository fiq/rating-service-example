package com.example.parentalcontrol.service.movieservice;

import com.example.parentalcontrol.domain.ParentalControlLevel;
import com.example.parentalcontrol.service.MovieService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Temporary stub for testing and standing up Parental Control
 * service until this dependency is satisfied.
 *
 * Conservatively restricts all content to a PC level of 18
 */
@Service
@Qualifier("movieServiceStub")
public class MovieServiceStub implements MovieService {

  public static final String NOT_FOUND_FIXTURE = "notfound-fixture";
  public static final String TECHNICAL_FAILURE_FIXTURE = "technicalfailure-fixture";
  private static final Pattern fixtureExtract = Pattern.compile("rating-(?<level>\\w+)-fixture");

  /**
   * Provides untime fixtures - demonstrating stubs for interview purposes, although I prefer mocks
   * or fake collaborators at the network tier
   * @param movie name
   * @return ParentalControlLevel of the movie
   * @throws TitleNotFoundException indicating that the movie could not be found
   * @throws TechnicalFailureException indicating that the MovieService had a technical failure
   */
  @Override
  public ParentalControlLevel getParentalControlLevel(String movie) throws TitleNotFoundException, TechnicalFailureException {
    // force a file not found behaviour
    if (movie.equals(NOT_FOUND_FIXTURE)) {
      throw new TitleNotFoundException(movie, "Not found");
    }

    // force a technical failure behaviour
    if (movie.equals(TECHNICAL_FAILURE_FIXTURE)) {
      throw new TechnicalFailureException(movie, "Failure");
    }

    Matcher fixtureMatch = fixtureExtract.matcher(movie);
    if (fixtureMatch.matches()) {
      String fixtureLevel = fixtureMatch.group("level");
      return ParentalControlLevel.lookupByRating.get(fixtureLevel);
    }

    return ParentalControlLevel.EIGHTEEN;
  }
}
