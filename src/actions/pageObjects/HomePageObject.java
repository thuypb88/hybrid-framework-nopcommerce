package actions.pageObjects;

import interfaces.pageUIs.HomePageUI;

public class HomePageObject {
    HomePageUI homePageUI = new HomePageUI();
    public void clickToRegisterLink() {
        System.out.println(homePageUI.REGISTER_LINK);
    }
}
