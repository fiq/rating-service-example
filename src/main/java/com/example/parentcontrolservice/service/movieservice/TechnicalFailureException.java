package com.example.parentcontrolservice.service.movieservice;

/**
 * Indicates a technical failure from the upstream MovieService
 */
public class TechnicalFailureException extends TitleNotFoundException {
  /**
   * Constructor for movie services errors, decorated with title
   *
   * @param movieTitle Title of the movie
   * @param error      A description of the error
   */
  public TechnicalFailureException(String movieTitle, String error) {
    super(movieTitle, error);
  }
}
