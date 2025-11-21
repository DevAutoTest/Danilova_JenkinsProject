package danilova.page;

import danilova.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserSettingsPagePOM extends BasePage {

    public UserSettingsPagePOM(WebDriver driver) {
        super(driver);
    }

    public StatusComponentUserPage clickStatus() {
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[@class='task-link task-link-no-confirm task-link--active']"))).click();
        return new StatusComponentUserPage(getDriver());
    }

    public AccountComponentUserPage clickAccount() {
        getWait10().until(ExpectedConditions
                .elementToBeClickable(By.xpath("(//a[@class='task-link task-link-no-confirm '])[3]"))).click();
        return new AccountComponentUserPage(getDriver());
    }
}
