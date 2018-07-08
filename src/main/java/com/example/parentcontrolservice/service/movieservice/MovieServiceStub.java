package com.example.parentcontrolservice.service.movieservice;

import com.example.parentcontrolservice.domain.ParentalControlLevel;
import com.example.parentcontrolservice.service.MovieService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Temporary stub for testing and standing up Parental Control
 * service until this dependency is satisfied.
 *
 * Conservatively restricts all content to a PC level of 18
 */
@Service
@Qualifier("movieServiceStub")
public class MovieServiceStub implements MovieService {
  @Override
  public ParentalControlLevel getParentalControlLevel(String movie) throws TitleNotFoundException, TechnicalFailureException {
    return ParentalControlLevel.EIGHTEEN;
  }
}
