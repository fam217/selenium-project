package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void uploading_test(){
        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        //2. Find some small file from your computer, and get the path of it.
        String path = "/Users/gurhan/Desktop/file.txt";
        /*
        Windows path option #1: C:\\Users\\hayat\\Desktop\\note.txt
        Windows path option #2: C://Users/hayat/Desktop/note.txt
         */

        //3. Upload the file. Use sendKeys() method and pass the "path" as a String.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.sleep(2);

        //This is the line that is passing the path of the file to website
        chooseFileButton.sendKeys(path);
        //chooseFileButton.sendKeys("/Users/gurhan/Desktop/file.txt");

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));

        uploadButton.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed(), "Header text is not displayed!!!");
    }
}
