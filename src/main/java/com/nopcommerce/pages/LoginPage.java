package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
        private WebDriver driver;
        private ElementUtil elementUtil;

    private By loginPageName = By.xpath("//div[@class='page-title']/h1");
    private By emailField = By.id("Email");
    private By  passwordField = By.id("Password");
    private By  rememberMeCheckBox = By.id("RememberMe");
    private By  loginBtn = By.xpath("//button[text()='Log in']");
    private By  registerBtn = By.xpath("//button[text()='Register']");
    private  By myAccountLink = By.linkText("My account");
    private  By logout = By.linkText("Log out");


   public LoginPage(WebDriver driver){

       this.driver=driver;
       elementUtil = new ElementUtil(driver);
   }

   public String getLoginPageName(){

      // return driver.findElement(loginPageName).getText();
       return  elementUtil.doGetText(loginPageName);
   }

   public HomePage doLogin(String userID, String password){
       elementUtil.doSendKeys(emailField,userID);
       elementUtil.doSendKeys(passwordField,password);
       elementUtil.doClick(loginBtn);
       //driver.findElement(emailField).sendKeys(userID);
       //driver.findElement(passwordField).sendKeys(password);
       //driver.findElement(loginBtn).click();
       return new HomePage(driver);

   }

    public boolean verifyRegisterButtonStatus() {
       return elementUtil.doIsDisplayed(registerBtn);
       //return driver.findElement(registerBtn).isDisplayed();
    }
}
