package epam.testauto.pages;

import epam.testauto.basics.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    public LoginPage openProfile() {
        clickElement(profileButton);
        return this;
    }

    public LoginPage typeLoginData(String sUsername, String sPassword) {
        setElementText(usernameTextBox, sUsername);
        setElementText(passwordTextBox, sPassword);
        return this;
    }

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
