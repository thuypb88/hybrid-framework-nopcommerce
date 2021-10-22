package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUIs.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public void clickToRegisterLink() {
        clickToElement(driver,HomePageUI.REGISTER_LINK);
    }
}
