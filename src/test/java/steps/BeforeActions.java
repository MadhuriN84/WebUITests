package steps;

import io.cucumber.java.*;
import utils.SeleniumDriver;

public class BeforeActions {
    @Before
    public static void setUp() throws Exception {
        SeleniumDriver.setUpDriver();
    }
}