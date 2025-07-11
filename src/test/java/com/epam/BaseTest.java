package com.epam;

import com.epam.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest  {
    WebDriver driver;
    LoginPage loginPage;
    private String browserName;

    public WebDriver initializeDriver(String browser){
        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        }
        else driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        return driver;

    }


    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        driver = initializeDriver(browser);
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
