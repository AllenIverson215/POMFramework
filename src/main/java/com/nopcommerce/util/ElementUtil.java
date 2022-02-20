package com.nopcommerce.util;

import com.nopcommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import java.security.SecureRandom;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;

    public ElementUtil(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(By locator){
         return driver.findElement(locator);

    }

    public List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    public void doClick(By locator){
        getElement(locator).click();
    }

    public void doSendKeys(By locator,String value){
        getElement(locator).sendKeys(value);
    }

    public boolean doIsDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }

    public String doGetText(By locator){
        return getElement(locator).getText();
    }

    public void waitFor(long milliSeconds){
        try{
            Thread.sleep(milliSeconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String randomString(int len){
        String abc = "0123456789abcdefghijklmnopqrstuvwxyz";
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<len;i++){
            sb.append(abc.charAt(sr.nextInt(abc.length())));
        }
        return sb.toString();
    }

    public List<WebElement> getAllDropdownOptions(By locator){
        Select select = new Select(getElement(locator));
        List<WebElement> options = select.getOptions();
        return  options;
    }

    public boolean compareDropDownOption(By locator,String[] expected){
        List<WebElement> options = getAllDropdownOptions(locator);
        int i =0;
        for (WebElement opt: options){
            if(!opt.getText().equals(expected[i])){
                return false;
            }
            i = i+1;

        }
        return true;
    }
}
