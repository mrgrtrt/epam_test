package epam.testauto.pageobjects;

import epam.testauto.basics.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Rita on 27.10.2016.
 */
public class RadioButton extends Element{
    public RadioButton(WebDriver driver, String text) {
        super(driver, By.xpath("//label[contains(., '" + text + "')]/input"));
    }
}
