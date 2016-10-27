/*package epam.testauto.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Rita on 27.10.2016.
 */
/*
public class JsAlert {
    private WebDriver driver;
    private String textAlert = "alert('The execution is started');";

    public JsAlert(WebDriver driver) {
        this.driver = driver;
    }

    public JsAlert generateAlert() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(textAlert);
        Assert.assertEquals(driver.switchTo().alert().getText(), textAlert);
        driver.switchTo().alert().accept();
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
}*/
