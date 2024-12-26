package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddResourceSteps {

    @When("the user adds a planet")
    public void the_user_adds_a_planet() {
        TestRunner.homePage.setSelectedBody("Planet");
    }

    @When("the user adds a moon")
    public void the_user_adds_a_moon() {
        TestRunner.homePage.setSelectedBody("Moon");
    }

    @When("the user enters an invalid planet name {string}")
    public void the_user_enters_an_invalid_planet_name(String planetName) {
        TestRunner.homePage.enterPlanetName(planetName);
    }

    @When("the user enters an invalid moon name {string}")
    public void the_user_enters_an_invalid_moon_name(String moonName) {
        TestRunner.homePage.enterMoonName(moonName);
    }

    @When("the user enters a valid planet name")
    public void the_user_enters_a_valid_planet_name() {
        TestRunner.homePage.enterPlanetName("Mars A-B_1234");
    }

    @When("the user enters a valid moon name")
    public void the_user_enters_a_valid_moon_name() {
        TestRunner.homePage.enterMoonName("Titan A-B_1234");
    }

    @When("the user enters an invalid owner id")
    public void the_user_enters_an_invalid_owner_id() {
        TestRunner.homePage.enterOwnerId("0");
    }

    @When("the user enters a valid owner id")
    public void the_user_enters_a_valid_owner_id() {
        TestRunner.homePage.enterOwnerId("1");
    }

    @When("the user selects an invalid planet image")
    public void the_user_selects_an_invalid_planet_image() {
        TestRunner.homePage.addPlanetImage("C:\\Users\\reese\\Revature\\Planetarium\\src\\test\\resources\\Celestial-Images\\invalid_file_type.gif");
    }

    @When("the user selects an invalid moon image")
    public void the_user_selects_an_invalid_moon_image() {
        TestRunner.homePage.addMoonImage("C:\\Users\\reese\\Revature\\Planetarium\\src\\test\\resources\\Celestial-Images\\invalid_file_type.gif");
    }

    @When("the user selects a valid planet image {string}")
    public void the_user_selects_a_valid_planet_image(String image) {
        TestRunner.homePage.addPlanetImage(image);
    }

    @When("the user selects a valid moon image {string}")
    public void the_user_selects_a_valid_moon_image(String image) {
        TestRunner.homePage.addMoonImage(image);
    }

    @When("the user clicks submit")
    public void the_user_clicks_submit() {
        TestRunner.homePage.clickSubmitButton();
    }

    @Then("the planet should be added")
    public void the_planet_should_be_added() {
        try {
            Thread.sleep(5000);
            List<WebElement> rows = TestRunner.homePage.getCelestialRows();
            String newPlanetName = TestRunner.homePage.getPlanetNameInput();

            boolean rowExists = false;
            for (WebElement row : rows) {
                if (row.getText().contains(newPlanetName)) {
                    rowExists = true;
                    break;
                }
            }
            Assert.assertTrue(rowExists);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the moon should be added")
    public void the_moon_should_be_added() {
        try {
            Thread.sleep(5000);
            List<WebElement> rows = TestRunner.homePage.getCelestialRows();
            String newMoonName = TestRunner.homePage.getMoonNameInput();

            boolean rowExists = false;
            for (WebElement row : rows) {
                if (row.getText().contains(newMoonName)) {
                    rowExists = true;
                    break;
                }
            }
            Assert.assertTrue(rowExists);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
