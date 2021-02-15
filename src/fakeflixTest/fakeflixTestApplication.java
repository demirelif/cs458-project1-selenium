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
    //@BeforeMethod
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
    public void verifyBeginningWithShortEmailAddress(){
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys("");
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }

    @Test(priority = 200)
    public void verifyBeginningWithEmailAddressWithoutAtCharacter(){
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys("utkuemail.com");
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }

    @Test(priority = 300)
    public void verifyBeginningWithEmailAddress(){
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys("utku@gmail.com");
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }
    @Test(priority = 400)
    public void continueButton(){
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }

    @Test(priority = 500)
    public void signUpWithoutPassword(){
        WebElement userPassword = driver.findElement(By.id("signup-password"));
        userPassword.sendKeys("");
        WebElement signUpButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        signUpButton.click();
    }
    @Test(priority = 600)
    public void signUpWithShortPassword(){
        WebElement userPassword = driver.findElement(By.id("signup-password"));
        userPassword.sendKeys("123");
        WebElement signUpButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        signUpButton.click();
    }
    @Test(priority = 700)
    public void signUp(){
        WebElement userPassword = driver.findElement(By.id("signup-password"));
        userPassword.sendKeys("12345");
        WebElement signUpButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        signUpButton.click();
        WebElement seeThePlansButton = driver.findElement(By.xpath("//input[@value='See the plans']"));
        seeThePlansButton.click();
    }



}
