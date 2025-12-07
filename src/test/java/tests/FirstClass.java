package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstClass extends BaseTest {
    private static final By TEXTCHECK = By.xpath("//*[span='Products']");
    private static final String TEXTMSG = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void logPass() {
        loginPage.open();
        loginPage.login();
        boolean productsBtnPresent = browser.findElement(TEXTCHECK).isDisplayed();
        assertTrue(productsBtnPresent);
    }

    @Test
    public void logFailed() {
        loginPage.open();
        loginPage.checkErrorMsg();
        assertEquals(loginPage.checkErrorMsg(), TEXTMSG);
    }

}