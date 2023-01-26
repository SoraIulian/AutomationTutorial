package ShareData;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class SharedData {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/Driver/chromedriver.exe" );
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Index.html");

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    //folosim after
    @AfterMethod
    public void Clear(){
        driver.quit();
    }



}

