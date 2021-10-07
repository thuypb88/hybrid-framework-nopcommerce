package testcases.com.nopcommerce.user;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_01_Register_DRY {
    WebDriver driver;
    String emailAddress;
    // Declare (khai báo)
    BasePage basePage;
    // BasePage : class
    // basePage: Object

    String projectPath = System.getProperty("user.dir");

    @BeforeClass // Multiple browsers
    public void beforeClass(){
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        // Driver có ID rồi

        // Initial (Khởi tạo)
        basePage = new BasePage();

        emailAddress = "afc_" + generateFakeNumber() + "@mailinator.com";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void f(){
    }
    @BeforeClass
    public void beforeClass(){
    }
    @AfterClass // Custom
    public void afterClass(){
    }

    public int generateFakeNumber(){
        Random rand = new Random();
        return rand.nextInt(9999);
    }

}
