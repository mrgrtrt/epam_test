package epam.testauto.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Rita on 27.10.2016.
 */
public class Element {
    private By locator;
    private WebElement element;
    private WebDriver driver;

    public Element(WebDriver driver,By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    protected WebElement getElement() {
        if (element == null) {
            element = driver.findElement(locator);
        }
        return element;
    };

    public boolean isChecked() {
        return getElement().isSelected();
    }

    public void check() {
        if (!isChecked()) {
            getElement().click();
        }
    }

}
