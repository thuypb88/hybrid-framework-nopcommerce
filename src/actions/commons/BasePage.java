package actions.commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

// Common class
public class BasePage {
    WebDriver driver;

    // Nhiệm vụ mở 1 Url ra
    // Common function
    public void openPageUrl(WebDriver driver, String pageUrl){
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();
    }
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

/*    public void waitForAlertPresence(WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }*/
    public Alert waitForAlertPresence(WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

/*    public void acceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
       }

       public void acceptAlert(WebDriver driver){
            Alert alert = waitForAlertPresence(driver);
            alert.accept();
        }
    }*/
    public void acceptAlert(WebDriver driver){
        waitForAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver){
        waitForAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver){
        return waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String textValue){
        waitForAlertPresence(driver).sendKeys(textValue);
    }

    public void switchToWindowByID(WebDriver driver, String windowID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for(String id : allWindowIDs){
            if(!id.equals(windowID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String tabTitle){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for(String id : allWindowIDs){
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if(actualTitle.equals(tabTitle)){
               break;
            }
        }
    }

    public void closeAllTabWithoutParent(WebDriver driver, String parentID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for(String id : allWindowIDs){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    public WebElement getWebElement(WebDriver driver, String xpathLocator){
        // driver.findElement(By.xpath(xpathLocator))
        return driver.findElement(By.xpath(xpathLocator));
    }

    public void clickToElement(WebDriver driver, String xpathLocator){
      //  call getWebElement()
        getWebElement(driver, xpathLocator).click();
    }

/*    public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue){
        getWebElement(driver, xpathLocator).clear();
        getWebElement(driver, xpathLocator).sendKeys(textValue);
    }*/

    public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue){
        WebElement element =  getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public void getElementText(WebDriver driver, String xpathLocator){
        getWebElement(driver, xpathLocator).getText();
    }
    public void selectItemDefaultDropdown(WebDriver driver, String xpathLocator, String textItem){
        Select select = new Select(getWebElement(driver, xpathLocator));
        select.selectByValue(textItem);
    }
    public String getSelectItemDefaultDropdown(WebDriver driver, String xpathLocator){
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String xpathLocator){
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.isMultiple();
    }
    public void sleepInSecond(long time){
        try{
            Thread.sleep(time * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
