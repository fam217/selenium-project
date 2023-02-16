package com.cydeo.tests.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LocatorPractice {

    public static void main(String[] args) {
        // TC#1: Practice page Login test
        // 1. Open Chrome browser
        // 2. Go to http://practice.cydeo.com/login

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Enter username: "tomsmith"

        WebElement username1 = driver.findElement(By.name("username"));

        username1.sendKeys("tomsmith");

        // 4. Enter password: "SuperSecretPassword"
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        WebElement loginBtn1 = driver.findElement(By.id("wooden_spoon")); //dont use value with space



        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!"
    }
}
