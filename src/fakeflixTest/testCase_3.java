package fakeflixTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class testCase_3 {
    static String url = "http://localhost:8888/cs458-project1/fakenetflix/signup3-1.html";
    WebDriver driver;
    @Test(priority = 0)
    public void testCase_3(){
        // INVOKE BROWSER
        //setting the driver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //Initiating your chromedriver
        driver = new ChromeDriver();
        //Applied wait time
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //open browser with desired URL
        driver.get(url);
        // GO TO SIGN IN PAGE
        WebElement signButton = driver.findElement(By.id("sign-button"));
        signButton.click();

        // FILL EMAIL/PHONE and password inputs
        WebElement name = driver.findElement(By.id("name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign In']"));

        name.sendKeys("nonexisting@gmail.com");
        password.sendKeys("12345678");
        signInButton.click();
        //driver.findElement(By.xpath("//a[text()='create a new account.']")).click();
        driver.findElement(By.linkText("create a new account.")).click();
        String resultLabel = driver.getCurrentUrl();
        Assert.assertEquals(resultLabel, "http://localhost:8888/cs458-project1/fakenetflix/index.html");
    }
    @AfterTest
    public void terminateBrowser() throws InterruptedException {
        sleep(2500);
        driver.close();
    }
}
