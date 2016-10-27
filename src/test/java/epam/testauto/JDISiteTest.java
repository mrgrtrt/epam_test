package epam.testauto;

//import epam.testauto.pageobjects.JsAlert;
import epam.testauto.pages.DifferentElementPage;
import epam.testauto.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Created by Rita on 26.10.2016.
 */
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

    /*@Test(priority = 3)
    public void checkAlert() throws InterruptedException {
        JsAlert jsAlert = new JsAlert(driver)
                            .generateAlert();
                            .getTextAlert()
                            .acceptAlert();
    }*/
}
