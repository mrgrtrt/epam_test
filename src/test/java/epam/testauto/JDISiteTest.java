package epam.testauto;

import epam.testauto.pageobjects.JsAlert;
import epam.testauto.pages.DifferentElementPage;
import epam.testauto.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;

public class JDISiteTest extends SetupDriver {
    private WebDriver driver;

    @BeforeSuite
    public void setup(){
        driver = getDriver();
    }

    @Test(priority = 0, dataProviderClass = Data.class, dataProvider = "login")
    public void login(boolean isCorrect, String sUsername, String sPassword) {
        LoginPage loginPage = new LoginPage(driver)
                        .openProfile()
                        .typeLoginData(sUsername, sPassword)
                        .submitLoginForm(isCorrect);
    }

    @Test(priority = 1)
    public void checkBox() {
        DifferentElementPage differentElementPage = new DifferentElementPage(driver)
                                   .checkAllCheckboxes()
                                   .uncheckAllCheckboxes();
    }

    @Test(priority = 2, dataProviderClass = Data.class, dataProvider = "radio")
    public void checkRadioButtons(String radioData) {
        DifferentElementPage differentElementPage = new DifferentElementPage(driver)
                                   .checkRadio(radioData);
    }

    @Test(priority = 3)
    public void checkAlert() throws WebDriverException{
        JsAlert jsAlert = new JsAlert(driver);
        try {
            jsAlert.generateAlert();
        } catch (WebDriverException e) {
            jsAlert.getTextAlert()
                    .acceptAlert();
        }
    }
}
