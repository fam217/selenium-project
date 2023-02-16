package com.cydeo.tests.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRM_SendingMessages extends TestBase {


    @Test
    public void sending_messages_test(){
        //       1. Users are already login and on the homepage
        driver.get(ConfigurationReader.getProperty("env"));

        CRM_Utilities.login_crm(driver);

        //CRM_Utilities.login_crm(driver,ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

        //       2. Users click the MESSAGE tab
        WebElement messageTab = driver.findElement(By.id("feed-add-post-form-tab-message"));
        messageTab.click();

        //       3. Users write test message
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        WebElement msgFrame = driver.findElement(By.tagName("body"));
        msgFrame.sendKeys("Hello World");


        //       4. Users click the SEND button
        // driver.switchTo().parentFrame();// If you have nested iframe and you want to go from child iframe to parent iframe
        driver.switchTo().defaultContent();// If you want to go back to Main HTML directly

        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));

        sendBtn.click();


        //       5. Verify the message is displayed on the feed
        //WebElement feed = driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
        String actualText = driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]")).getText();
        String expectedText = "Hello World";
        Assert.assertEquals(actualText,expectedText,"Text did not appear in feed!");



    }
}