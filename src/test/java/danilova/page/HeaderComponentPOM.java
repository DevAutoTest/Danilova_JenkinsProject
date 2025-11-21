package danilova.page;

import danilova.page.All.SearchModalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderComponentPOM {

    WebDriver driver;
    WebDriverWait wait;

    private final By jenkinsIcon = By.className("app-jenkins-logo");
    private final By search = By.id("root-action-ManageJenkinsAction");
    private final By manageJenkins = By.id("root-action-ManageJenkinsAction");
    private final By userDropDownMenu = By.xpath("//a[@id='root-action-UserAction']");

    public HeaderComponentPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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

    public UserSettingsPagePOM clickUserHeaderMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropDownMenu)).click();
        return new UserSettingsPagePOM(driver);
    }
}
