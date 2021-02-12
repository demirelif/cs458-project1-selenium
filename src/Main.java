import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Main {
    static String url = "http://localhost:8888/cs458-project1/fakenetflix/";
    WebDriver driver;

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
    @Test
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main wc = new Main();
        wc.invokeBrowser();
        wc.getTitle();
        //wc.closeBrowser();
    }


}