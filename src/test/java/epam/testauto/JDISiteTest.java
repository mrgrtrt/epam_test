package epam.testauto;

import epam.testauto.pageobjects.JsAlert;
import epam.testauto.pages.DifferentElementPage;
import epam.testauto.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Title;

@Title("JDI-framework site test-suite")
public class JDISiteTest extends SetupDriver {
    private WebDriver driver;

    @BeforeSuite
    public void setup(){
        driver = getDriver();
    }

    @Title("Login check")
    @Test(priority = 1, dataProviderClass = Data.class, dataProvider = "login")
    public void login(boolean isCorrect, String sUsername, String sPassword) {
        LoginPage loginPage = new LoginPage(driver)
                        .openProfile()
                        .typeLoginData(sUsername, sPassword)
                        .submitLoginForm(isCorrect);

    }

    @Title("Checkbox check with various switching")
    @Test(priority = 2, dataProviderClass = Data.class, dataProvider = "checkbox")
    public void checkBox(boolean waterCheck, boolean earthCheck, boolean windCheck, boolean fireCheck) {
        DifferentElementPage differentElementPage = new DifferentElementPage(driver)
                                   .checkboxesCheck(waterCheck, earthCheck, windCheck, fireCheck);
    }

    @Title("Radio buttons check")
    @Test(priority = 3, dataProviderClass = Data.class, dataProvider = "radio")
    public void checkRadioButtons(String radioData) {
        DifferentElementPage differentElementPage = new DifferentElementPage(driver)
                                   .checkRadio(radioData);
    }

    @Title("JavaScript generating and handling check")
    @Test(priority = 4)
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
