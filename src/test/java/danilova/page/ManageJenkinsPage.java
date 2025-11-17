package danilova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import danilova.common.BasePage;

public class ManageJenkinsPage extends BasePage {

    public ManageJenkinsPage(WebDriver driver) {
        super(driver);
    }

    public ManageUsersPage clickUserLink() {
        getDriver().findElement(By.xpath("//a[@href='securityRealm/']")).click();

        return new ManageUsersPage(getDriver());
    }
}
