package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    //#1- Initialize the object of the class and the driver instance inside the constructor
    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // WebElement signInButton = Driver.getDriver().findElement(By.xpath("//button[.='Sign in']"));

    //#2- Use @FindBy annotation instead of findElement method
    @FindBy(id = "inputEmail" )
    public WebElement emailInput;

    @FindBy(id="inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='This field is required.']/div")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrorMessage;


}