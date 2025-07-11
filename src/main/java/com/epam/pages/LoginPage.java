package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Elements of the page
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    private  WebElement errorMessageField;

    //Interactions
    public void enterUsername(String username) {
       userNameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

   public void clearPasswordField(){
        passwordField.clear();
   }

   public void clearUserNameField(){
        userNameField.clear();
   }

   public void clickLoginButton(){
        loginBtn.click();
   }

   public String getErrorMessage(){
       return errorMessageField.getText();
   }








}
