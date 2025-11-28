package danilova.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDownAccountMenuComponent extends HeaderComponentsPOM {

    private final By statusUserId = By.xpath("//div[contains(text(),'Jenkins User ID:')]");
    private final By accountDropDownMenu = By.xpath("//a[contains(@class, 'jenkins-dropdown__item') and normalize-space(.)='Account']");

    public DropDownAccountMenuComponent(WebDriver driver) {
        super(driver);
    }

    @Step("[DropDownAccountMenuComponent] Click Account in DropDown menu")
    public AccountComponentUserPage clickDropDownMenuAccount() {
        driver.findElement(accountDropDownMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1")));
        return new AccountComponentUserPage(driver);
    }

    @Step("[DropDownAccountMenuComponent] Click Status in DropDown menu")
    public StatusComponentUserPage clickDropDownMenuStatus(String user) {
        By xpath = By.xpath(String.format("//a[contains(@class, 'jenkins-dropdown__item') and normalize-space(.)='%s']", user));
        for (int i = 0; i < 3; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
                return new StatusComponentUserPage(driver);
            } catch (org.openqa.selenium.StaleElementReferenceException e) {

            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(statusUserId));
        return new StatusComponentUserPage(driver);
    }

    @Step("Get account full name")
    public String getDropDownMenuFullName(String userFullName) {
        return driver.findElement(By.xpath(String.format("//a[@href='/user/%s']", userFullName))).getText();
    }
}
