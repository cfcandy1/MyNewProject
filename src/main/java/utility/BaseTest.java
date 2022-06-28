package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static utility.Constant.adukURL;

public class BaseTest {
    public WebDriver browser;

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
}
