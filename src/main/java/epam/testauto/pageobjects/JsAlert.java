package epam.testauto.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;


public class JsAlert {
    private WebDriver driver;
    private String textAlert = "The execution is started";

    public JsAlert(WebDriver driver) {
        this.driver = driver;
    }

    public JsAlert generateAlert() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + textAlert + "');");

        return this;
    }

    public JsAlert acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public JsAlert getTextAlert() {
        Assert.assertEquals(driver.switchTo().alert().getText(), textAlert);
        return this;
    }
}
