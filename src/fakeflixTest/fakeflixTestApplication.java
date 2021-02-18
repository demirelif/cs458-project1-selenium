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

    //@BeforeMethod
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

    public void browserTestingCommon() throws InterruptedException {
        //Applied wait time
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //open browser with desired URL
        driver.get(url);

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

        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton.click();

        WebElement signInEmailOrPhone = driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        WebElement signInPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signInSubmit = driver.findElement(By.xpath("//input[@value='Sign In']"));

        signInEmailOrPhone.sendKeys("utku@gmail.com");
        signInPassword.sendKeys("12345");
        signInSubmit.click();

        String resultLabel = driver.getCurrentUrl();
        Assert.assertEquals(resultLabel, "http://localhost:8888/cs458-project1/fakenetflix/signedin.html");

        //sleep(2500);
        //driver.close();
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
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
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


    @Test(priority = 400)
    public void testCase_4(){
        setUp();
        WebElement userEmail = driver.findElement(By.id("signupmail"));
        userEmail.sendKeys("utku@gmail.com");
        WebElement startButton = driver.findElement(By.xpath("//input[@value='Get Started >']"));
        startButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='nextPageButton']"));
        continueButton.click();

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

        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton.click();

        WebElement signInEmailOrPhone = driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        WebElement signInPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signInSubmit = driver.findElement(By.xpath("//input[@value='Sign In']"));

        signInEmailOrPhone.sendKeys("utku@gmail.com");
        signInPassword.sendKeys("1234566789");
        signInSubmit.click();

        driver.findElement(By.linkText("reset your password.")).click();
        String resultLabel = driver.getCurrentUrl();
        Assert.assertEquals(resultLabel, "http://localhost:8888/cs458-project1/fakenetflix/signinHelp.html");
    }


    @Test(priority = 500)
    public void testCase_5() throws InterruptedException {
        setUp();
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

        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton.click();

        WebElement signInEmailOrPhone = driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        WebElement signInPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signInSubmit = driver.findElement(By.xpath("//input[@value='Sign In']"));

        signInEmailOrPhone.sendKeys("utku@gmail.com");
        signInPassword.sendKeys("12345");
        signInSubmit.click();

        String resultLabel = driver.getCurrentUrl();
        Assert.assertEquals(resultLabel, "http://localhost:8888/cs458-project1/fakenetflix/signedin.html");
    }

    @AfterMethod
    public void terminateBrowser() throws InterruptedException {
        sleep(800);
        driver.close();
    }


}
