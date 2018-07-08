package com.example.parentalcontrol.service.movieservice;

import lombok.Getter;

/**
 * Indicates that the MovieService is not familiar with the title
 */
public class TitleNotFoundException extends RuntimeException {
  @Getter
  private String movieTitle;

  /**
   * Constructor for movie services errors, decorated with title
   * @param movieTitle Title of the movie
   * @param error A description of the error
   */
  public TitleNotFoundException(String movieTitle, String error) {
    super(error);
    this.movieTitle = movieTitle;
  }
}
