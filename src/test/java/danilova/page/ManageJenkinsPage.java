package danilova.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import danilova.common.BasePage;

public class ManageJenkinsPage extends BasePage {

    public ManageJenkinsPage(WebDriver driver) {
        super(driver);
    }

    @Step("[ManageUserPage] Click user link")
    public ManageUsersPage clickUserLink() {
        getDriver().findElement(By.xpath("//a[@href='securityRealm/']")).click();

        return new ManageUsersPage(getDriver());
    }
}
