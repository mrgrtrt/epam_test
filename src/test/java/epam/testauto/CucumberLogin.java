package epam.testauto;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import epam.testauto.pages.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CucumberLogin {

    private FirefoxDriver driver;
    LoginPage loginPage;

    @Given("^the profile button is clicked$")
    public void setup(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://jdi-framework.github.io/tests/");
        loginPage = new LoginPage(driver).openProfile();
    }

    @When("^I login as (.*)/(.*)$")
    public void login(String username, String password) {
        loginPage.typeLoginData(username, password);
    }

    @Then("^submit form with '(.*)' argument$")
    public void submitForm(boolean isCorrect) {
        loginPage.submitLoginForm(isCorrect);
        driver.quit();
    }
}
