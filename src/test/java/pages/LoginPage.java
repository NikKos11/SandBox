package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver browser;
    WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));

    private static final By USER_NAME = By.xpath("//input[@id='user-name']");
    private static final By PASSWORD = By.xpath("//input[@id='password']");
    private static final By LOGIN = By.xpath("//input[@id='login-button']");
    private static final By TEXTMSG = By.xpath("//*[h3]");

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open() {
        browser.get("https://www.saucedemo.com/");
    }

    public void login() {
        browser.findElement(USER_NAME).sendKeys("standard_user");
        browser.findElement(PASSWORD).sendKeys("secret_sauce");
        browser.findElement(LOGIN).click();
    }

    public String checkErrorMsg() {
        browser.findElement(USER_NAME).sendKeys("error_user");
        browser.findElement(PASSWORD).sendKeys("123456");
        browser.findElement(LOGIN).click();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXTMSG));
        return browser.findElement(TEXTMSG).getText();
    }
}
