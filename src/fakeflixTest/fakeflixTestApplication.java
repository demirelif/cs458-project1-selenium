package fakeflixTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fakeflixTestApplication {
    static String url = "http://localhost:8888/cs458-project1/fakenetflix/signup3-1.html";
    WebDriver driver;

    @Test(priority = -100)
    public void testCase_1(){
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
        //
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys("utku@gmail.com");
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();

        // //input[@placeholder='Add a Password']
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='signup-password']"));
        //WebElement userPassword = driver.findElement(By.xpath("//input[@placeholder='Add a Password']"));
        userPassword.sendKeys("12345");
        WebElement signUpButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        signUpButton.click();
        WebElement seeThePlansButton = driver.findElement(By.xpath("//input[@value='See the plans']"));
        seeThePlansButton.click();


        WebElement continueButton2 = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton2.click();
        WebElement continueToPaymentButton = driver.findElement(By.xpath("//input[@value='Credit or Debit Card']"));
        continueToPaymentButton.click();

        WebElement firstName = driver.findElement(By.id("creditcard-firstname"));
        WebElement lastName = driver.findElement(By.id("creditcard-lastname"));
        WebElement cardNumber = driver.findElement(By.id("creditcard-number"));
        WebElement expDate = driver.findElement(By.id("creditcard-expdate"));
        WebElement cvv = driver.findElement(By.id("creditcard-cvv"));
        firstName.sendKeys("Utku");
        lastName.sendKeys("Kalkanlı");
        cardNumber.sendKeys("1111222233334444");
        expDate.sendKeys("0823");
        cvv.sendKeys("345");
        WebElement agreeButton = driver.findElement(By.id("iagree-checkbox"));
        agreeButton.click();
        WebElement startMemberShipButton = driver.findElement(By.xpath("//input[@value='Start Membership']"));
        startMemberShipButton.click();
        WebElement signOutButton = driver.findElement(By.xpath("//input[@value='Sign Out']"));
        signOutButton.click();


        WebElement userEmailLate = driver.findElement(By.id("signupmail"));
        userEmailLate.sendKeys("utku@gmail.com");
        WebElement startButtonLate = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButtonLate.click();
        WebElement continueButtonLate = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButtonLate.click();

        // //input[@placeholder='Add a Password']
        WebElement userPasswordLate = driver.findElement(By.xpath("//input[@id='signup-password']"));
        //WebElement userPassword = driver.findElement(By.xpath("//input[@placeholder='Add a Password']"));
        userPasswordLate.sendKeys("12345");
        WebElement signUpButtonLate = driver.findElement(By.xpath("//input[@value='Continue']"));
        signUpButtonLate.click();
    }

    @Test(priority = 0)
    public void testCase_2(){
        // test me !!
    }


}
