package com.epam;

import com.epam.pages.LoginPage;
import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest extends BaseTest {


    @Test(dataProvider = "getData2",testName = "UC-1 Test Login form with empty credentials")
    public void loginWithEmptyCredentials(HashMap<String,String> input) {
        loginPage.enterUsername(input.get("user"));
        loginPage.enterPassword(input.get("password"));
        loginPage.clearUserNameField();
        loginPage.clearPasswordField();
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"),
                "Error message should contain '" + "Username is required" + "' but was: " + loginPage.getErrorMessage());
    }

    @Test(dataProvider = "getData2",testName = "UC-2 Test Login form with credentials by passing Username")
    public void loginWithMissingPassword(HashMap<String,String> input) throws InterruptedException {
        loginPage.enterUsername(input.get("user"));
        loginPage.enterPassword(input.get("password"));
        loginPage.clearPasswordField();
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"),
                "Error message should contain '" + "Password is required" + "' but was: " + loginPage.getErrorMessage());
    }

    @Test(dataProvider = "getData", testName = "UC-3 Test Login form with credentials by passing Username & Password")
    public void ValidateSuccessfulLogin(HashMap<String, String> input) {
        loginPage.enterUsername(input.get("user"));
        loginPage.enterPassword(input.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Title is not correct");
    }

    @DataProvider()
    public Object[][] getData() {
        HashMap<String, String> credentialsSet1 = new HashMap<>();
        credentialsSet1.put("user", "standard_user");
        credentialsSet1.put("password", "secret_sauce");
        HashMap<String, String> credentialsSet2 = new HashMap<>();
        credentialsSet2.put("user", "locked_out_user");
        credentialsSet2.put("password", "secret_sauce");
        HashMap<String, String> credentialsSet3 = new HashMap<>();
        credentialsSet3.put("user", "problem_user");
        credentialsSet3.put("password", "secret_sauce");
        HashMap<String, String> credentialsSet4 = new HashMap<>();
        credentialsSet4.put("user", "performance_glitch_user");
        credentialsSet4.put("password", "secret_sauce");
        HashMap<String, String> credentialsSet5 = new HashMap<>();
        credentialsSet5.put("user", "error_user");
        credentialsSet5.put("password", "secret_sauce");
        HashMap<String, String> credentialsSet6 = new HashMap<>();
        credentialsSet6.put("user", "visual_user");
        credentialsSet6.put("password", "secret_sauce");
        return new Object[][]{
                {credentialsSet1},
                {credentialsSet2},
                {credentialsSet3},
                {credentialsSet4},
                {credentialsSet5},
                {credentialsSet6}
        };

    }

    @DataProvider()
    public Object[][] getData2() {
        HashMap<String, String> credentialsSet7 = new HashMap<>();
        credentialsSet7.put("user", "standard_user");
        credentialsSet7.put("password", "secret_sauce");
        return new Object[][]{{credentialsSet7}};


    }
}


