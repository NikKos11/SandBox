package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstClass extends BaseTest {

    @Test
    public void logPass() {
        loginPage.open();
        loginPage.login();
        boolean productsBtnPresent = browser.findElement(By.xpath("//*[span='Products']")).isDisplayed();
        assertTrue(productsBtnPresent);
//        browser.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys(Keys.CONTROL + "A");
//        browser.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys(Keys.BACK_SPACE);
//        browser.findElement(By.cssSelector("input[name = 'zip_code']"));
//        browser.findElement(By.name("zip_code"));
    }

    @Test
    public void logFailed() {
        loginPage.open();
        loginPage.checkErrorMsg();
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username and password do not match any user in this service");
    }

}

//        Alert alert = browser.switchTo().alert();
//        alert.accept();
//        browser.switchTo().frame("");
//        browser.switchTo().defaultContent();