package com.cydeo.tests.day12_review;

import com.cydeo.pages.W3Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick_Practice {

    //TC #1: Double Click Test 1. Goto
    //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    //2. Switch to iframe.
    //3. Double-click on the text“Double-click me to change my text color.”
    //4. Assert:Text’s“style” attribute value contains “red”.

    @Test
    public void t1_double_click_test(){
        //TC #1: Double Click Test 1. Goto
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double-click on the text “Double-click me to change my text color.”
        //Using W3Page object to reach to the 'paragraph' web element.
        W3Page w3Page = new W3Page();

        //Using Actions object to be able to 'double-click' to the given web element.
        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(w3Page.paragraph).perform();

        //4. Assert:Text’s “style” attribute value contains “red”.
        // style="color: red;" --> "color: red;"
        String actualStyleAttributeValue = w3Page.paragraph.getAttribute("style");
        String expectedInAttributeValue = "red";

        Assert.assertTrue(actualStyleAttributeValue.contains(expectedInAttributeValue));
    }

}