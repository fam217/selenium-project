package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //Setup browser driver
        WebDriverManager.chromedriver().setup();

        //Create instance of Chrome browser
        WebDriver driver = new ChromeDriver();
        //SessionID: 4435741da99f778a4f20f537ed796993
        //SessionID: 3bd91c488ca90d19c1b6b7f9c234562a

        //This line will maximize the currently opened browser
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        //Go to tesla.com
        driver.get("https://www.tesla.com");

        //use .getCurrentUrl method to print out current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


        //get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);


        //User navigate back() to go back
        driver.navigate().back();

        //Stop execution for 3 seconds
        Thread.sleep(1000);

        //User navigate forward() to go forward
        driver.navigate().forward();

        //Stop execution for 3 seconds
        Thread.sleep(1000);

        //User refreshes the page using navigate.refresh();
        driver.navigate().refresh();

        //Stop execution for 3 seconds
        Thread.sleep(1000);

        //navigate to google.com using navigate().to();
        driver.navigate().to("https://www.google.com");

        //use .getCurrentUrl method to print out current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());

        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //closes only the currently focused window/tab
        driver.close();

        //closes all-of-the opened browsers
        driver.quit();


    }

}