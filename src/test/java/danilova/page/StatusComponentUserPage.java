package danilova.page;

import danilova.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusComponentUserPage extends BasePage {

    public StatusComponentUserPage(WebDriver driver) {
        super(driver);
    }

    public String getFullUserName() {
        return find(By.xpath("//div//h1")).getText();
    }
}
