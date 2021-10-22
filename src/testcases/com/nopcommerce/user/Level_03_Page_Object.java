package testcases.com.nopcommerce.user;

import actions.commons.BasePage;
import actions.pageObjects.HomePageObject;
import actions.pageObjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Level_03_Page_Object{
    @BeforeClass
    public void beforeClass(){
    }
    @Test
    public void TC_01_Register_Empty_Data(){
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Register Page - Step 02: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register Page - Step 03: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTxt(),"First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastnameTxt(),"Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTxt(),"Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTxt(),"Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTxt(),"Confirm Password is required.");

    }
    public void TC_02_Register_Invalid_Email(){
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Register Page - Step 02: Input to required fields");
        registerPage.inputToFirstnameTxt("Demo");
        registerPage.inputToLastnameTxt("Test");
        registerPage.inputToEmailTxt("123@123!@#$");
        registerPage.inputToPasswordTxt("12345678");
        registerPage.inputToConfirmPaswordTxt("12345678");

        System.out.println("Register Page - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTxt(),"Wrong email.");
    }
    public void TC_03_Register_Success(){
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Register Page - Step 02: Input to required fields");
        registerPage.inputToFirstnameTxt("Demo");
        registerPage.inputToLastnameTxt("Test");
        registerPage.inputToEmailTxt("123@123.com");
        registerPage.inputToPasswordTxt("12345678");
        registerPage.inputToConfirmPaswordTxt("12345678");

        System.out.println("Register Page - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify success message displayed");
        Assert.assertEquals(registerPage.getSuccessMessageAtEmailTxt(),"Your registration completed.");
    }
    public void TC_04_Register_Existing_Email(){
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Register Page - Step 02: Input to required fields");
        registerPage.inputToFirstnameTxt("Demo");
        registerPage.inputToLastnameTxt("Test");
        registerPage.inputToEmailTxt(emailAddress);
        registerPage.inputToPasswordTxt("12345678");
        registerPage.inputToConfirmPaswordTxt("12345678");

        System.out.println("Register Page - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");

    }
    public void TC_05_Register_Password_Less_Than_6_Chars(){
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Register Page - Step 02: Input to required fields");
        registerPage.inputToFirstnameTxt("Demo");
        registerPage.inputToLastnameTxt("Test");
        registerPage.inputToEmailTxt(emailAddress);
        registerPage.inputToPasswordTxt("123");
        registerPage.inputToConfirmPaswordTxt("123");

        System.out.println("Register Page - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"Password must meet the following rules:\nmust have at least 6 characters");
    }
    public void TC_06_Register_Invalid_Confirm_Password(){
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Register Page - Step 02: Input to required fields");
        registerPage.inputToFirstnameTxt("Demo1");
        registerPage.inputToLastnameTxt("Test");
        registerPage.inputToEmailTxt(emailAddress);
        registerPage.inputToPasswordTxt("12345678");
        registerPage.inputToConfirmPaswordTxt("12345677");

        System.out.println("Register Page - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The password and confirmation password do not match.");
    }

    @AfterClass
    public void afterClass(){
    }

    public int generateFakeNumber(){
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    private WebDriver driver;
    private String emailAddress;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private String projectPath = System.getProperty("user.dir");
}
