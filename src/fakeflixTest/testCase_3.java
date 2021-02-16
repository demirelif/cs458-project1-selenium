package fakeflixTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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

        name.sendKeys("ut ku  ");
        password.sendKeys("     ");
        signInButton.click();
        String error = driver.switchTo().alert().getText();
        driver.switchTo().notify();
        System.out.println(error);
    }
}
