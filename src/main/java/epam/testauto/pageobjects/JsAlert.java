package epam.testauto.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class JsAlert {
    private WebDriver driver;
    private String textAlert = "The execution is started";

    public JsAlert(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Generate JavaScript alert")
    public JsAlert generateAlert() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + textAlert + "');");

        return this;
    }

    @Step("Accept JavaScript alert")
    public JsAlert acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    @Step("Get text from JavaScript alert")
    public JsAlert getTextAlert() {
        Assert.assertEquals(driver.switchTo().alert().getText(), textAlert);
        return this;
    }
}
