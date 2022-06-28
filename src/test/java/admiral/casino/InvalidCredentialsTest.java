package admiral.casino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static utility.Constant.adukURL;


public class InvalidCredentialsTest {

    static WebDriver browser;

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
    public void verifyErrorMessage() {
        browser.findElement(By.xpath("//a[@class='link link-main-header']"))
                .click();
        browser.findElement(By.id("nickname"))
                .sendKeys("fakeuser2000");
        browser.findElement(By.id("password"))
                .sendKeys("fakeuser2000");
        browser.findElement(By.xpath("//*[@id=\"dialog\"]/div/div[2]/div/app-login/form/div/button"))
                .click();

        String expectedErrorMessage = "Incorrect nickname/password combination.";
        String actualErrorMessage = browser.findElement(By.xpath("//*[@id=\"dialog\"]/div/div[2]/div/app-login/form/app-alert/div/ul/li"))
                .getText();
        if (expectedErrorMessage.equalsIgnoreCase(actualErrorMessage)) {
            System.out.println("Error message is correct");
        } else {
            System.out.println("Error message is incorrect");
        }
    }

    @AfterTest
    public void tearDown() {
        browser.quit();
    }
}
