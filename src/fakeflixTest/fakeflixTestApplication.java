package fakeflixTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fakeflixTestApplication {
    static String url = "http://localhost:8888/cs458-project1/fakenetflix/";
    WebDriver driver;

    @Test(priority = -100)
    public void invokeBrowser(){
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
    }
    @Test(priority = 0)
    public void verifyTitleOfThePage(){
        String expectedTitle = "Fakeflix";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test(priority = 100)
    public void verifyBeginningWithEmailAddress(){
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys("utku@gmail.com");
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }
    @Test(priority = 200)
    public void continueButton(){
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }


}
