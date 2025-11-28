package danilova.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import danilova.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ManageUsersPage extends BasePage {

    private final String url = "/securityRealm/";
    private final By createUserButton = By.xpath("//a[@href='addUser']");
    private final By listOfUsers = By.xpath("//tr/td/a");
    private final By yesDeleteDialogButton = By.xpath("//button[@data-id='ok']");

    public ManageUsersPage(WebDriver driver) {
        super(driver);
    }

    @Step("[ManageUsersPage] Click create user button")
    public CreateUserPage clickCreateUserButton() {
        getDriver().findElement(createUserButton).click();
        return new CreateUserPage(getDriver());
    }

    @Step("[ManageUsersPage] Get <String> list of users")
    public List<String> getListUsers() {
        getWait2().until(ExpectedConditions.presenceOfElementLocated(listOfUsers));
        return getDriver().findElements(listOfUsers)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    @Step("[ManageUsersPage] Get <WebElement> list of users")
    public List<WebElement> getLisWebElementsUsers() {
        getWait2().until(ExpectedConditions.presenceOfElementLocated(listOfUsers));
        return getDriver().findElements(listOfUsers)
                .stream()
                .toList();
    }

    @Step("[ManageUsersPage] Deleting created users")
    public ManageUsersPage deleteUser(String userName) {
        List<String> listUsers = getListUsers();
        for (String user : listUsers) {
            if (user.toLowerCase().contains(userName.toLowerCase())) {
                getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[@data-url='user/%s/doDelete']", user.toLowerCase()))));
                getDriver().findElement(By.xpath(String.format("//a[@data-url='user/%s/doDelete']", user.toLowerCase()))).click();
                getDriver().findElement(yesDeleteDialogButton).click();
            }
        }
        return new ManageUsersPage(getDriver());
    }
}
