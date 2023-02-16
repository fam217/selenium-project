package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_xpath {

    public static void main(String[] args) {

        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        String expectedLoginText = "Log In";

        //tagName[@attribute='value']
        //Locating loginButton using xpath using type attribute's value
        //WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        //Locating loginButton using xpath using value attribute's value
        //WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));

        //Locating loginButton using xpath using class attribute's value
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        String actualLoginText = loginButton.getAttribute("value"); //--> Log In

        if (actualLoginText.equals(expectedLoginText)){
            System.out.println("Log In button text verification PASSED!");
        }else {
            System.out.println("Log In button text verification FAILED!");
        }


    }

}