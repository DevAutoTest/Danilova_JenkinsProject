package danilova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import danilova.common.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManageUsersPage extends BasePage {

    private final String url = "/securityRealm/";

    public ManageUsersPage(WebDriver driver) {
        super(driver);
    }

    public CreateUserPage clickCreateUserButton() {
        getDriver().findElement(By.xpath("//a[@href='addUser']")).click();
        return new CreateUserPage(getDriver());
    }

    public String getCreatedUserName(String userName) {
        return getDriver().findElement(By.xpath("//td[text()='%s']".formatted(userName))).getText();
    }

    public List<WebElement> getListUsers() {
        return getDriver().findElements(By.xpath("//tr/td/a"))
                .stream().toList();
    }
}
