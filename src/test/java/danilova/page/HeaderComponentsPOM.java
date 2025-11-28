package danilova.page;

import danilova.common.ProjectUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderComponentsPOM {

    WebDriver driver;
    WebDriverWait wait;

    private final By jenkinsLogo = By.className("app-jenkins-logo");
    private final By searchIcon = By.id("root-action-SearchAction");
    private final By manageJenkinsIcon = By.id("root-action-ManageJenkinsAction");
    private final By dropDownMenuAccountIcon = By.xpath("//a[@id='root-action-UserAction']");

    public HeaderComponentsPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("[HeaderComponents] Click home page icon")
    public HomePage clickHomePageIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(jenkinsLogo)).click();
        return new HomePage(driver);
    }

    @Step("[HeaderComponents] Click search icon")
    public SearchModalPage clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
        return new SearchModalPage(driver);
    }

    @Step("[HeaderComponents] Click manageJenkins icon")
    public ManageJenkinsPage clickManageJenkinsHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(manageJenkinsIcon)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(normalize-space(.), 'Manage Jenkins')]")));
        return new ManageJenkinsPage(driver);
    }

    @Step("[HeaderComponents] Hover over account icon")
    public DropDownAccountMenuComponent hoverOverAccountIcon() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(dropDownMenuAccountIcon)).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='account-theme-picker']")));
        return new DropDownAccountMenuComponent(driver);
    }

    //Doesn't work in Ci
    @Step("[HeaderComponents] Click account icon in header")
    public StatusComponentUserPage clickAccountIcon(WebDriver driver, String className, String methodName) {
        By dropdown = By.xpath("//select[@id='account-theme-picker']");
        WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(dropDownMenuAccountIcon));

        new Actions(driver).moveToElement(icon).pause(Duration.ofMillis(300)).perform();

        ProjectUtils.takeScreenshot(driver, className, methodName);
        new Actions(driver).moveToElement(icon).pause(Duration.ofMillis(300)).click().perform();
        return new StatusComponentUserPage(driver);
    }

}
