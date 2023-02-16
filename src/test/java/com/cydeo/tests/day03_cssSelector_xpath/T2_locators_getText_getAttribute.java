package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_locators_getText_getAttribute {

    public static void main(String[] args) {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedLabelText = "Remember me on this computer";
        String actualLabelText = driver.findElement(By.className("login-item-checkbox-label")).getText();

        if (actualLabelText.equals(expectedLabelText)){
            System.out.println("Label text verification PASSED!");
        }else{
            System.out.println("Label text verification FAILED!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        String expectedForgotPasswordText = "FORGOT YOUR PASSWORD?";

        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordText = forgotPasswordLink.getText();

        if (actualForgotPasswordText.equals(expectedForgotPasswordText)){
            System.out.println("FPT verification is PASSED!");
        }else {
            System.out.println("actualForgotPasswordText = " + actualForgotPasswordText);
            System.out.println("expectedForgotPasswordText = " + expectedForgotPasswordText);
            System.out.println("FPT verification is FAILED!!!");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedInHref = "forgot_password=yes";
        String actualHrefValue = forgotPasswordLink.getAttribute("href");

        if (actualHrefValue.contains(expectedInHref)){
            System.out.println("HREF attribute value is as EXPECTED. PASS!");
        }else{
            System.out.println("HREF attribute value is NOT as EXPECTED. FAIL!!!");
        }
    }
}