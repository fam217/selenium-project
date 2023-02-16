package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class T1_CydeoVerifications {

    public static void main(String[] args) {


        //TC #1: Cydeo practice tool verifications
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //3. Verify URL contains
        //Expected: cydeo

        String expectedInUrl = "cydeo";

        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedInUrl));{
            System.out.println("URL verification PASSED!!!");
        }{
            System.out.println("URL verification FAILED!!!");
        }


        //4. Verify title:
        //Expected: Practice

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle(); // returns "Practice"

driver.close();
    }
}


