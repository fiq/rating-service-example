package com.example.parentcontrolservice.cucumber.steps;

import com.example.parentcontrolservice.ParentalControlServiceAT;
import com.example.parentcontrolservice.controller.ParentalControlController;
import com.example.parentcontrolservice.cucumber.World;
import com.example.parentcontrolservice.cucumber.model.APIShape;
import com.example.parentcontrolservice.cucumber.model.TestableParentalControlLevel;
import com.example.parentcontrolservice.domain.ParentalControlLevel;
import com.example.parentcontrolservice.service.MovieService;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.parentcontrolservice.cucumber.model.APIShape.PARENTAL_CONTROL_QUERY;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by raf on 6/07/18.
 */

@ContextConfiguration(loader = SpringBootContextLoader.class, classes = ParentalControlServiceAT.class)
@WebMvcTest(ParentalControlController.class)
public final class ParentalControllerSteps implements En{

  @Autowired
  @MockBean
  MovieService movieService;
  
  // TODO encapsulate in world
  @Autowired
  MockMvc mockMvc;

  public ParentalControllerSteps (@Autowired World world) {
    Given("mother has a parental control preference setting of (.+)", (String preferredLevel) -> {
      TestableParentalControlLevel preferenceLevel = TestableParentalControlLevel.lookupByRating.get( preferredLevel );
      // TODO handle NPE
      world.setParentalLevelPreference(preferenceLevel);
    });

    Given("^(\\w+) has a parental control level of (.+)", (String movie, String parentalControlLevel) -> {
      TestableParentalControlLevel movieLevel = TestableParentalControlLevel.lookupByRating.get(parentalControlLevel);
      // TODO handle NPE
      world.setMovieParentalLevel(movieLevel);

      ParentalControlLevel movieLevelFixture =
          ParentalControlLevel.lookupByRating.get(movieLevel.getParentalControlLevel());
      when(movieService.getParentalControlLevel(movie)).thenReturn(movieLevelFixture);
    });

    When("mother attempts to watch (\\w+)", (String movie) -> {
      TestableParentalControlLevel preferenceLevel = world.getParentalLevelPreference();
      String url = APIShape.serviceUrlFor(movie, preferenceLevel);

      ResultActions response = mockMvc.perform(get(url));

      // check status
      response.andExpect(status().isOk());
      world.setResponse(response);
    });

    Then("she will not be permitted to watch it", () -> {
      world.getResponse().andExpect(jsonPath(PARENTAL_CONTROL_QUERY, is(false)));
    });

    Then("she will be permitted to watch it", () -> {
      world.getResponse().andExpect(jsonPath(PARENTAL_CONTROL_QUERY, is(true)));
    });
  }
}
