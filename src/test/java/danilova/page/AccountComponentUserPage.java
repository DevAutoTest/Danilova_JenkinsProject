package danilova.page;

import danilova.common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AccountComponentUserPage extends BasePage {

    HeaderComponentsPOM header;
    private final By fullNameField = By.cssSelector("input.jenkins-input[name='_.fullName']");

    public AccountComponentUserPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponentsPOM(getDriver());
    }

    @Step("[Account page] Get full name")
    public String getFullName() {
        return find(By.cssSelector("input.jenkins-input[name='_.fullName']")).getAttribute("value");
    }

    @Step("[Account page] Clear full name")
    public AccountComponentUserPage clearFullName() {
        find(fullNameField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        find(fullNameField).sendKeys(Keys.DELETE);
        return new AccountComponentUserPage(getDriver());
    }

    @Step("[Account page] Send full name")
    public AccountComponentUserPage sendFullName(String newName) {
        find(fullNameField).sendKeys(newName);
        return new AccountComponentUserPage(getDriver());
    }

    @Step("[Account page] Click Save button")
    public StatusComponentUserPage clickSave() {
        find(By.xpath("//button[@formnovalidate ='formNoValidate' and @name='Submit']")).click();
        return new StatusComponentUserPage(getDriver());
    }

    @Step("[Account page] Click Apply button")
    public AccountComponentUserPage clickApply() {
        find(By.xpath("//button[@name='Apply']")).click();
        return new AccountComponentUserPage(getDriver());
    }
}
