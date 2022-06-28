package admiral.casino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static utility.Constant.adukURL;

public class LoginTest {

    public static WebDriver browser;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/andrew/Downloads/Selenium/chromedriver");
        browser = new ChromeDriver();
        browser.get(adukURL);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        browser.findElement(By.id("user"))
                .sendKeys("admin");
        browser.findElement(By.id("password"))
                .sendKeys("matrix4215");
        browser.findElement(By.xpath("/html/body/form/input[4]"))
                .click();

        browser.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']"))
                .click();
    }

    @Test
    public void verifyLoginSuccess() {
        this.browser = new ChromeDriver();
        browser.findElement(By.xpath("//a[@class='link link-main-header']"))
                .click();
        browser.findElement(By.id("nickname"))
                .sendKeys("stagtestrmg1");
        browser.findElement(By.id("password"))
                .sendKeys("qwertz12strmg");

        Boolean loginButtonEnabled = browser.findElement(By.xpath("//*[@id=\"dialog\"]/div/div[2]/div/app-login/form/div/button"))
                .isEnabled();
        if (loginButtonEnabled) {
            System.out.println("Yes ! Element is enabled");
        } else {
            System.out.println("NO ! Element is not enabled or present");
        }

        browser.findElement(By.xpath("//*[@id=\"dialog\"]/div/div[2]/div/app-login/form/div/button"))
                .click();
        Boolean loginSuccess = browser.findElement(By.xpath("//div[@class='item item-userpic ng-star-inserted']"))
                .isDisplayed();
        if (loginSuccess) {
            System.out.println("Login is successful!");
        } else {                                              // verify login success
            System.out.println("Login is NOT successful!");
        }
    }

    @AfterTest
    public void tearDown() {
        browser.quit();
    }
}

