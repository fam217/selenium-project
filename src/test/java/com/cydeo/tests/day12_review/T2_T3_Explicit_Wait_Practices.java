package com.cydeo.tests.day12_review;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_T3_Explicit_Wait_Practices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();

    }

    @Test
    public void t2_remove_checkbox_test(){
        //TC #2: Explicit wait practice


        //3- Click to “Remove” button

        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        //Using the custom utility method 'waitForInvisibilityOf' to wait loadingBar disappears
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        // dynamicControlsPage.checkbox.isDisplayed() --> if displayed, returns true;
        // dynamicControlsPage.checkbox.isDisplayed() --> if not displayed, returns false;

        //Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());

        try{
            //assertFalse method is expecting a "false" boolean value to PASS the test.
            Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());

        }catch (NoSuchElementException n){
            //n.printStackTrace();
            System.out.println("NoSuchElementException is thrown. It means that the Checkbox is not on the page.");
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
    }

    @Test
    public void t3_input_input_box_test(){
        //3- Click to “Enable” button
        //use the object to click to enable button
        dynamicControlsPage.enableButton.click();

        //4- Wait until “loading bar disappears”
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled(), "Input box is not enabled!!!");

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed(), "Message is not enabled!!!");

        String actualMessageText = dynamicControlsPage.message.getText();

        Assert.assertTrue(actualMessageText.equals("It's enabled!"));
    }

    @AfterMethod
    public void teardownMethod(){
        Driver.closeDriver();
    }

}