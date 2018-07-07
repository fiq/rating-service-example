package com.example.parentcontrolservice.cucumber.steps;

import com.example.parentcontrolservice.cucumber.World;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by raf on 6/07/18.
 */
public class ParentalControllerSteps implements En{

  public ParentalControllerSteps (World world) {
    Given("mother has a parental control preference setting of (.+)", (String preferredLevel) -> {
      System.out.println("IN MOTHER'S SETTING");
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });

    Given("Jaws has a parental control level of (.+)", (String parentalControlLevel) -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
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
