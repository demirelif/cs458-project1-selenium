package fakeflixTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class testCase_1 {
    static String url = "http://localhost:8888/cs458-project1/fakenetflix/signup3-1.html";
    //static String url = "http://localhost:8888/cs458-project1/fakenetflix/";
    WebDriver driver;

    @Test(priority = -100)
    public void testCase_1() throws InterruptedException {
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

        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

        WebElement signInEmailOrPhone = driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        WebElement signInPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));

        signInEmailOrPhone.sendKeys("utku@gmail.com");
        signInPassword.sendKeys("12345");
        WebElement hideShowButton = driver.findElement(By.xpath("//button[@id='hideShow']"));
        for(int i = 0; i < 5; i++){
            hideShowButton.click();
            // IN THIS IF CONDITION TEST SHOULD FAIL
            if(hideShowButton.getText().equals("HIDE") && signInPassword.getAttribute("type").equals("password")){
                Assert.assertEquals("HIDE", "password"); // THIS WILL FAIL THE TEST
            }
            Thread.sleep(300);
        }
    }
    @AfterTest
    public void terminateBrowser() throws InterruptedException {
        sleep(2500);
        driver.close();
    }

}
