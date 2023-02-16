package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_Login_Task {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void test1_crm_login(){
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to`LogIn`button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "(2) Portal");

    }

    @Test
    public void test2_crm_login(){

        //Logging in using the utility method we created in CRM_Utilities class
        CRM_Utilities.login_crm(driver);

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "(2) Portal");

    }

    @Test
    public void test3_crm_login(){

        //Logging in using the utility method we created in CRM_Utilities class
        //CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com", "UserUser");
        CRM_Utilities.login_crm(driver, "helpdesk2@cydeo.com", "UserUser");

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "(2) Portal");

    }

}