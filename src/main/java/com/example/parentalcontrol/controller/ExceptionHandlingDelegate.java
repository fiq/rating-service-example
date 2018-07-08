package com.example.parentalcontrol.controller;

import com.example.parentalcontrol.domain.MovieServiceError;
import com.example.parentalcontrol.service.movieservice.TitleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * ExceptionHandler for acceptance scenarios
 */
@ControllerAdvice
public class ExceptionHandlingDelegate extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TitleNotFoundException.class)
  protected ResponseEntity<MovieServiceError> handleTitleNotFound(TitleNotFoundException ex) {
    MovieServiceError errorResponse = MovieServiceError.builder()
        .title( ex.getMovieTitle() )
        .error( "Title is not recognised")
        .movieIsSuitableForCustomer(false)
        .build();
    // Since we key off a /movie/xxx resource, the movie not existing is a 404
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }
}
