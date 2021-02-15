import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main {
    static String url = "http://localhost:8888/cs458-project1/fakenetflix/";
    WebDriver driver;
    @BeforeMethod
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

    public void getTitle(){
        String titleOfThePage = driver.getTitle();
        System.out.println("Title of the page - " + titleOfThePage);
    }

    public void closeBrowser(){
        //closing the browser
        // close command closes currently active window
        //driver.close();
        // quit closes all windows
        driver.quit();
    }
    public void verifyTitleOfThePage(){
        String expectedTitle = "Fakeflix";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    public void verifyBeginningWithShortEmailAddress(){
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys("");
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }
    public void verifyBeginningWithEmailAddressWithoutAtCharacter(){
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys("utkuemail.com");
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }

    public void verifyBeginningWithEmailAddress(){
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys("utku@gmail.com");
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }
    public void continueButton(){
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();
    }

    public void signUpWithoutPassword(){
        WebElement userPassword = driver.findElement(By.id("signup-password"));
        userPassword.sendKeys("");
        WebElement signUpButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        signUpButton.click();
    }
    public void signUpWithShortPassword(){
        WebElement userPassword = driver.findElement(By.id("signup-password"));
        userPassword.sendKeys("123");
        WebElement signUpButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        signUpButton.click();
    }
    public void signUp(){
        WebElement userPassword = driver.findElement(By.id("signup-password"));
        userPassword.sendKeys("12345");
        WebElement signUpButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        signUpButton.click();
        WebElement seeThePlansButton = driver.findElement(By.xpath("//input[@value='See the plans']"));
        seeThePlansButton.click();
    }
    @Test
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main wc = new Main();
        wc.invokeBrowser();
        wc.getTitle();
        wc.verifyTitleOfThePage();
        wc.verifyBeginningWithShortEmailAddress();
        wc.verifyBeginningWithEmailAddressWithoutAtCharacter();
        wc.verifyBeginningWithEmailAddress();
        wc.continueButton();
        wc.signUpWithoutPassword();
        wc.signUpWithShortPassword();
        wc.signUp();
        wc.closeBrowser();
    }


}