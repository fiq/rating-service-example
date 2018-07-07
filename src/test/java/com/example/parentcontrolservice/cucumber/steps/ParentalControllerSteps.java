package com.example.parentcontrolservice.cucumber.steps;

import com.example.parentcontrolservice.cucumber.World;
import com.example.parentcontrolservice.cucumber.model.TestableParentalControlLevel;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by raf on 6/07/18.
 */
public class ParentalControllerSteps implements En{

  public ParentalControllerSteps (World world) {
    Given("mother has a parental control preference setting of (.+)", (String preferredLevel) -> {
      TestableParentalControlLevel preferenceLevel = TestableParentalControlLevel.lookupByRating.get( preferredLevel );

      //TODO handle NPE
      world.setParentalLevelPreference(preferenceLevel);
    });

    Given("Jaws has a parental control level of (.+)", (String parentalControlLevel) -> {
      TestableParentalControlLevel movieLevel = TestableParentalControlLevel.lookupByRating.get(parentalControlLevel);
      //TODO handle NPE
      world.setMovieParentalLevel(movieLevel);
    });

    When("mother attempts to watch Jaws", () -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });

    Then("she will not be permitted to watch it", () -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });
  };
}
