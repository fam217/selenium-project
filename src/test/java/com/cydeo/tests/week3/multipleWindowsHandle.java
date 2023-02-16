package com.cydeo.tests.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class multipleWindowsHandle extends TestBase {

    @Test
    public void multiple_windows_handle_test(){
        // TC : Windows handle practice
        //    1. Open browser
        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get(ConfigurationReader.getProperty("demo.qa.url"));

        WebElement newTab = driver.findElement(By.id("tabButton"));
        WebElement newWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
        WebElement newWindowMsg = driver.findElement(By.cssSelector("#messageWindowButton"));

        //    3. Click on New Tab button
        newTab.click();

        //    4. Click on New Window button
        newWindow.click();

        //    5. Click on New Window Message button
        newWindowMsg.click();

        //    6. Store parent window handle id in a variable
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String mainWindow = driver.getWindowHandle();
        System.out.println("mainWindow = " + mainWindow);


        //    7. Store all window handle ids in to a Set
        Set<String> allWindows = driver.getWindowHandles();

        //    9. Print out each window id
        for (String eachWindow : allWindows) {
            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            //System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        // At the end of testing you may need to go back to default(main) window
        driver.switchTo().window(mainWindow);


    }
}