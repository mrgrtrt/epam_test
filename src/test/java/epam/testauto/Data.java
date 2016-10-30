package epam.testauto;

import org.testng.annotations.DataProvider;


public class Data {

    @DataProvider(name = "login")
    public static Object[][] logData() {
        return new Object[][] {
                {false, "", ""},
                {false, "epam", ""},
                {false, "", "1234"},
                {false, "user", "password"},
                {true, "epam", "1234"}
        };
    }

    @DataProvider(name = "checkbox")
    public static Object[][] checkboxData() {
        return new Object[][] {
                {true, false, false, false},
                {false, true, false, false},
                {false, false, true, false},
                {false, false, false, true},
                {true, true, false, false},
                {true, false, true, false},
                {true, false, false, true},
                {false, true, true, false},
                {false, true, false, true},
                {false, false, true, true},
                {true, true, true, false},
                {true, true, false, true},
                {false, true, true, true},
                {true, false, true, true},
                {true, true, true, true},
                {false, false, false, false}
        };
    }

    @DataProvider(name = "radio")
    public static Object[][] radioData() {
        return new Object[][] {
                {"Gold"},
                {"Silver"},
                {"Bronze"},
                {"Selen"}
        };
    }

}

