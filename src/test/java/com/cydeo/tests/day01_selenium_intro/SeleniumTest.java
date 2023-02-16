package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {

        //1- Setting up the web driver manager
        WebDriverManager.chromedriver().setup();

        //2. Create the instance of Chrome browser driver
        WebDriver driver = new ChromeDriver();

        //3. Test if driver and browser are working as expected
        driver.get("https://www.google.com");



    }
}
