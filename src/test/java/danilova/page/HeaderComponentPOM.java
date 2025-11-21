package danilova.page;

import danilova.page.All.SearchModalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class HeaderComponentPOM {

    WebDriver driver;
    WebDriverWait wait;

    private final By jenkinsIcon = By.className("app-jenkins-logo");
    private final By search = By.id("root-action-ManageJenkinsAction");
    private final By manageJenkins = By.id("root-action-ManageJenkinsAction");
    private final By dropDownMenuAccount = By.xpath("//a[@id='root-action-UserAction']");

    public HeaderComponentPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public HomePage clickHomePageIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(jenkinsIcon)).click();
        return new HomePage(driver);
    }

    //SearchModalPage - переписать
    public SearchModalPage clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(search)).click();
        return new SearchModalPage(driver);
    }

    public ManageJenkinsPage clickManageJenkinsHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(manageJenkins)).click();
        return new ManageJenkinsPage(driver);
    }

//    public UserSettingsPagePOM clickUserHeaderMenu() {
//        wait.until(ExpectedConditions.elementToBeClickable(userDropDownMenu)).click();
//        return new UserSettingsPagePOM(driver);
//    }

    public DropDownAccountMenuComponent hoverOverAccountIcon() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(dropDownMenuAccount)).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='account-theme-picker']")));
        return new DropDownAccountMenuComponent(driver);
    }

    public StatusComponentUserPage clickAccountIcon() {
        WebElement accountButton = wait.until(ExpectedConditions.elementToBeClickable(dropDownMenuAccount));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", accountButton);
        return new StatusComponentUserPage(driver);
    }

//    public StatusComponentUserPage clickOverAccountIcon()  {
//    WebElement accountButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("root-action-UserAction")));
//   //     new Actions(driver).moveToElement(accountButton, 2, 0).click().perform();
//        driver.findElement(dropDownMenuAccount).click();
//
////        new Actions(getDriver())
////                .moveToElement(getWait5().until(ExpectedConditions.elementToBeClickable(By.id("root-action-UserAction"))))
////                .click()
////                .perform();
//
////        TestUtils.clickJS(getDriver(), By.id("root-action-UserAction"));
//
//  //  wait.until(ExpectedConditions.urlContains("/user/")); //for debug
//        return new StatusComponentUserPage(driver);
//    }
}
