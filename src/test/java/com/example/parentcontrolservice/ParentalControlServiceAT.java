package com.example.parentcontrolservice;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Acceptance Tests for ParentalControlService
 */
@RunWith(Cucumber.class)
@SpringBootTest
@WebAppConfiguration
@Configuration
@ComponentScan("com.example.*")
public class  ParentalControlServiceAT {
}
