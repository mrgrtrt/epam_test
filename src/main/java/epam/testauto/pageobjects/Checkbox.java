package epam.testauto.pageobjects;

import epam.testauto.basics.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Rita on 27.10.2016.
 */
public class Checkbox extends Element {
    public Checkbox(WebDriver driver, String text) {
        super(driver, By.xpath("//label[contains(., '" + text + "')]/input"));
    }

    public void uncheck() {
        if (isChecked()) {
            getElement().click();
        }
    }

}
