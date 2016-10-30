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

    private void checkboxSwitch(Checkbox checkbox, boolean toCheck) {
        if (toCheck) {
            checkbox.check();
        } else checkbox.uncheck();
    }

    public DifferentElementPage(WebDriver driver) {
        super(driver);
        loadPage("https://jdi-framework.github.io/tests/page8.htm");
        water = new Checkbox(driver, "Water");
        earth = new Checkbox(driver, "Earth");
        wind = new Checkbox(driver, "Wind");
        fire = new Checkbox(driver, "Fire");
    }

    public DifferentElementPage checkboxesCheck(boolean waterCheck, boolean earthCheck, boolean windCheck, boolean fireCheck) {
        checkboxSwitch(water, waterCheck);
        checkboxSwitch(earth, earthCheck);
        checkboxSwitch(wind, windCheck);
        checkboxSwitch(fire, fireCheck);

        Assert.assertEquals(waterCheck, water.isChecked());
        Assert.assertEquals(earthCheck, earth.isChecked());
        Assert.assertEquals(windCheck, wind.isChecked());
        Assert.assertEquals(fireCheck, fire.isChecked());
        return this;
    }

    public DifferentElementPage checkRadio(String radioData) {
        radioButton = new RadioButton(driver, radioData);
        radioButton.check();
        Assert.assertTrue(radioButton.isChecked());
        return this;
    }
}
