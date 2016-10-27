package epam.testauto.pages;

import epam.testauto.basics.BasePage;
import epam.testauto.pageobjects.Checkbox;
import epam.testauto.pageobjects.RadioButton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DifferentElementPage extends BasePage {
    private Checkbox water;
    private Checkbox earth;
    private Checkbox wind;
    private Checkbox fire;
    private RadioButton radioButton;

    public DifferentElementPage(WebDriver driver) {
        super(driver);
        loadPage("https://jdi-framework.github.io/tests/page8.htm");
        water = new Checkbox(driver, "Water");
        earth = new Checkbox(driver, "Earth");
        wind = new Checkbox(driver, "Wind");
        fire = new Checkbox(driver, "Fire");
    }

    public DifferentElementPage checkAllCheckboxes() {
        water.check();
        earth.check();
        wind.check();
        fire.check();
        Assert.assertTrue(water.isChecked());
        Assert.assertTrue(earth.isChecked());
        Assert.assertTrue(wind.isChecked());
        Assert.assertTrue(fire.isChecked());

        return this;
    }

    public DifferentElementPage uncheckAllCheckboxes() {
        water.uncheck();
        earth.uncheck();
        wind.uncheck();
        fire.uncheck();
        Assert.assertFalse(water.isChecked());
        Assert.assertFalse(earth.isChecked());
        Assert.assertFalse(wind.isChecked());
        Assert.assertFalse(fire.isChecked());
        return this;
    }

    public DifferentElementPage checkRadio(String radioData) {
        radioButton = new RadioButton(driver, radioData);
        radioButton.check();
        Assert.assertTrue(radioButton.isChecked());
        return this;
    }
}
