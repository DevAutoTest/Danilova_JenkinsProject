package danilova.page;

import danilova.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AccountComponentUserPage extends BasePage {

    HeaderComponentPOM header;

    public AccountComponentUserPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponentPOM(getDriver());
    }

    public String getFullName() {
        return find(By.cssSelector("input.jenkins-input[name='_.fullName']")).getAttribute("value");
    }

    public AccountComponentUserPage clearFullName() {
        find(By.cssSelector("input.jenkins-input[name='_.fullName']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        find(By.cssSelector("input.jenkins-input[name='_.fullName']")).sendKeys(Keys.DELETE);
        return new AccountComponentUserPage(getDriver());
    }

    public AccountComponentUserPage sendFullName(String newName) {
        find(By.cssSelector("input.jenkins-input[name='_.fullName']"))
                .sendKeys(newName);
        return new AccountComponentUserPage(getDriver());
    }

    public StatusComponentUserPage clickSave() {
        find(By.xpath("//button[@formnovalidate ='formNoValidate' and @name='Submit']")).click();
        return new StatusComponentUserPage(getDriver());
    }

    public AccountComponentUserPage clickApply() {
        find(By.xpath("//button[@name='Apply']")).click();
        return new AccountComponentUserPage(getDriver());
    }
}
