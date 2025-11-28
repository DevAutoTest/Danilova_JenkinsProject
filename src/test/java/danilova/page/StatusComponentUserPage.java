package danilova.page;

import danilova.common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StatusComponentUserPage extends BasePage {

    public StatusComponentUserPage(WebDriver driver) {
        super(driver);
    }

    @Step("[StatusPage] Get full user name")
    public String getFullUserName() {
        return find(By.xpath("//div//h1")).getText();
    }
}
