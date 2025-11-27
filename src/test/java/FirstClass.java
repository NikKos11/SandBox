import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstClass {

//    открыть браузер
//    зайти на сайт

    @Test
    public void zipCode() throws InterruptedException {
        WebDriver browser = new ChromeDriver();
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys("123456");
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(1000);
        boolean registerBtnPresent = browser.findElement(By.xpath("//input[@value='Register']")).isDisplayed();
        assertTrue(registerBtnPresent);
//        browser.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys(Keys.CONTROL + "A");
//        browser.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys(Keys.BACK_SPACE);
//        browser.findElement(By.cssSelector("input[name = 'zip_code']"));
//        browser.findElement(By.name("zip_code"));

        browser.quit();
    }

    @Test
    public void zipDigitCode() throws InterruptedException {
        WebDriver browser = new ChromeDriver();
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys("12");
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(1000);
        String errorText = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorText, "Oops, error on page. ZIP code should have 5 digits");
    }
}
