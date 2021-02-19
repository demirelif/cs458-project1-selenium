package fakeflixTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

public class fakeflixTestApplication {
    static String url = "http://localhost:8888/cs458-project1/fakenetflix/signup3-1.html";
    WebDriver driver;
    String validEmail = "utku@gmail.com";
    String validPassword = "12345";
    String invalidEmail = "nonexisting@gmail.com";
    String invalidPassword = "12345678";

    public void setUp(){
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

    @Test(priority = 100)
    public void testCase_1() throws InterruptedException {
        setUp();
        // go to sign in page
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        WebElement signInEmailOrPhone = driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        WebElement signInPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));

        signInEmailOrPhone.sendKeys(validEmail);
        signInPassword.sendKeys(validPassword);
        WebElement hideShowButton = driver.findElement(By.xpath("//button[@id='hideShow']"));
        // test hide/show functionality
        for(int i = 0; i < 5; i++){
            hideShowButton.click();
            // IN THIS IF CONDITION TEST SHOULD FAIL
            if(hideShowButton.getText().equals("HIDE") && signInPassword.getAttribute("type").equals("password")){
                Assert.assertEquals("HIDE", "password"); // THIS WILL FAIL THE TEST
            }
            Thread.sleep(300);
        }
    }
    // common browser testing code piece, invokes browser, signs-up, signs in
    public void browserTestingCommon() throws InterruptedException {
        //Applied wait time
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //open browser with desired URL
        driver.get(url);

        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys(validEmail);
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();

        // //input[@placeholder='Add a Password']
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='signup-password']"));
        //WebElement userPassword = driver.findElement(By.xpath("//input[@placeholder='Add a Password']"));
        userPassword.sendKeys(validPassword);
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

        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton.click();

        WebElement signInEmailOrPhone = driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        WebElement signInPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signInSubmit = driver.findElement(By.xpath("//input[@value='Sign In']"));

        signInEmailOrPhone.sendKeys(validEmail);
        signInPassword.sendKeys(validPassword);
        signInSubmit.click();

        String resultLabel = driver.getCurrentUrl();
        // if we are signed in test is passed
        Assert.assertEquals(resultLabel, "http://localhost:8888/cs458-project1/fakenetflix/signedin.html");
    }
    @Test(priority = 200)
    public void chromeTesting() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        browserTestingCommon();
    }

    @Test(priority = 240)
    public void firefoxTesting() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        driver = new FirefoxDriver();
        browserTestingCommon();
    }

    @Test(priority = 280)
    public void edgeTesting() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "msedgedriver");
        driver = new EdgeDriver();
        browserTestingCommon();
    }

    @Test(priority = 300)
    public void testCase_3(){
        setUp();

        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton.click();

        WebElement signInEmailOrPhone = driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        WebElement signInPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signInSubmit = driver.findElement(By.xpath("//input[@value='Sign In']"));

        signInEmailOrPhone.sendKeys("invalid@gmail.com");
        signInPassword.sendKeys("1234589");
        signInSubmit.click();

        //driver.findElement(By.xpath("//a[text()='create a new account.']")).click();
        driver.findElement(By.linkText("create a new account.")).click();
        String resultLabel = driver.getCurrentUrl();
        Assert.assertEquals(resultLabel, "http://localhost:8888/cs458-project1/fakenetflix/index.html");
    }


    @Test(priority = 400)
    public void testCase_4(){
        setUp();
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys(validEmail);
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();

        WebElement userPassword = driver.findElement(By.xpath("//input[@id='signup-password']"));
        //WebElement userPassword = driver.findElement(By.xpath("//input[@placeholder='Add a Password']"));
        userPassword.sendKeys(validPassword);
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

        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton.click();

        WebElement signInEmailOrPhone = driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        WebElement signInPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signInSubmit = driver.findElement(By.xpath("//input[@value='Sign In']"));

        signInEmailOrPhone.sendKeys(validEmail);
        signInPassword.sendKeys(invalidPassword);
        signInSubmit.click();

        driver.findElement(By.linkText("reset your password.")).click();
        String resultLabel = driver.getCurrentUrl();
        Assert.assertEquals(resultLabel, "http://localhost:8888/cs458-project1/fakenetflix/signinHelp.html");
    }


    @Test(priority = 500)
    public void testCase_5() throws InterruptedException {
        setUp();

        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys(validEmail);
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();

        WebElement userPassword = driver.findElement(By.xpath("//input[@id='signup-password']"));
        userPassword.sendKeys(validPassword);
        WebElement signUpButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        signUpButton.click();
        WebElement seeThePlansButton = driver.findElement(By.xpath("//input[@value='See the plans']"));
        seeThePlansButton.click();

        WebElement continueButton2 = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton2.click();
        WebElement continueToPaymentButton = driver.findElement(By.xpath("//input[@value='Credit or Debit Card']"));
        continueToPaymentButton.click();
        // fill credit card information
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

        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton.click();

        WebElement signInEmailOrPhone = driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        WebElement signInPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signInSubmit = driver.findElement(By.xpath("//input[@value='Sign In']"));

        signInEmailOrPhone.sendKeys(validEmail);
        signInPassword.sendKeys(validPassword);
        signInSubmit.click();

        String resultLabel = driver.getCurrentUrl();
        Assert.assertEquals(resultLabel, "http://localhost:8888/cs458-project1/fakenetflix/signedin.html");
    }

    // THIS METHOD RUNS AFTER ALL TEST CASES AND TERMINATES BROWSER INSTANCE
    @AfterMethod
    public void terminateBrowser() throws InterruptedException {
        //sleep(800);
        driver.close();
    }


}
