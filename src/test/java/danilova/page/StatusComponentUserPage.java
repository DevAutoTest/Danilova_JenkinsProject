package danilova.page;

import danilova.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StatusComponentUserPage extends BasePage {

    public StatusComponentUserPage(WebDriver driver) {
        super(driver);
    }

    public String getFullUserName() {
        return find(By.xpath("//div//h1")).getText();
    }

    public String getUserNameInBreadcrumbs(String userName) {

                WebElement userNameText = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//a[@href='/user/%s/']".formatted(userName))));
                return userNameText.getText();
    }
}
