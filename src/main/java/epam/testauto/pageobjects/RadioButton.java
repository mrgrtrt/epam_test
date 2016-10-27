package epam.testauto.pageobjects;

import epam.testauto.basics.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton extends Element{
    public RadioButton(WebDriver driver, String text) {
        super(driver, By.xpath("//label[contains(., '" + text + "')]/input"));
    }

    public boolean isChecked() {
        return getElement().isSelected();
    }

    public void check() {
        if (!isChecked()) {
            getElement().click();
        }
    }
}
