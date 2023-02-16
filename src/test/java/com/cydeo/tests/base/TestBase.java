package com.cydeo.tests.base;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


// This class is parent of all Test classes
// Since we are not going to create any object from that class we make it "abstract"
// You can update this class based on what you are keep writing in your most test classes
// instead writing in all Test classes, you can just write in this class
// and you can extends this class from any Test class
public abstract class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterMethod
    public void teardownMethod(){
        BrowserUtils.sleep(3);
        driver.quit();
        //driver.close();
    }
}