package com.nopcommerce.base;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoginPage;
import com.nopcommerce.pages.RegisterPage;
import com.nopcommerce.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public  BasePage basepage;
    public  Properties prop;
    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public SearchPage searchPage;

    @BeforeTest
    // challenge point
    public  void setup(){
        basepage = new BasePage();
        prop = basepage.init_prop();
        String browserType = prop.getProperty("browser");
        driver= basepage.init_driver(browserType);
        homePage = new HomePage(driver);
        driver.get(prop.getProperty("url"));


    }

    @AfterTest
    public void tearDown(){
        driver.quit();

    }
}
