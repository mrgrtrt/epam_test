package epam.testauto.pages;

import epam.testauto.basics.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends BasePage {

    private String errorMessage = "* Login Faild";

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;
    @FindBy(id = "Login")
    private WebElement usernameTextBox;
    @FindBy(id = "Password")
    private WebElement passwordTextBox;
    @FindBy(css = "button.btn-login")
    private WebElement enterButton;
    @FindBy(xpath = "//span[@class='login-txt']")
    private WebElement errorMessageText;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("Open login box by clicking on the profile-button")
    public LoginPage openProfile() {
        clickElement(profileButton);
        return this;
    }

    @Step("Typing username and password")
    public LoginPage typeLoginData(String sUsername, String sPassword) {
        setElementText(usernameTextBox, sUsername);
        setElementText(passwordTextBox, sPassword);
        return this;
    }

    @Step("Submit login form and check if it's right")
    public LoginPage submitLoginForm(boolean isCorrect) {
        clickElement(enterButton);
        if (!isCorrect) {
            Assert.assertEquals(errorMessage, errorMessageText.getText());
            driver.navigate().refresh();
            loadPage("https://jdi-framework.github.io/tests/page1.htm");
        }
        return this;
    }

}
