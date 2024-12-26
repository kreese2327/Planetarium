package com.revature.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "locationSelect")
    private WebElement celestialBodySelect;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(className = "submit-button")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageGreeting() {
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows() {
        return driver.findElements(By.tagName("tr")).size() - 1;
    }

    public List<WebElement> getCelestialRows() {
        return driver.findElements(By.tagName("tr"));
    }

    public void tryToAccessHomePageDirectly() {
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout() {
        logoutButton.click();
    }

    public void setSelectedBody(String body) {
        Select select = new Select(celestialBodySelect);
        select.selectByVisibleText(body);
    }

    public void enterPlanetName(String planetName) {
        planetNameInput.sendKeys(planetName);
    }

    public String getPlanetNameInput() {
        return planetNameInput.getAttribute("value");
    }

    public void enterMoonName(String moonName) {
        moonNameInput.sendKeys(moonName);
    }

    public String getMoonNameInput() {
        return moonNameInput.getAttribute("value");
    }

    public void enterOwnerId(String ownerId) {
        orbitedPlanetInput.sendKeys(ownerId);
    }

    public void addPlanetImage(String image) {
        planetImageInput.sendKeys(image);
    }

    public void addMoonImage(String image) {
        moonImageInput.sendKeys(image);
    }

    public void enterDeleteInput(String celestialBodyName) {
        deleteInput.sendKeys(celestialBodyName);
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public String getDeleteInput() {
        return deleteInput.getAttribute("value");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}