package danilova.page;

import danilova.models.UserData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import danilova.common.BasePage;

import java.util.List;

public class CreateUserPage extends BasePage {

    private final By userNameField = By.id("username");
    private final By fullUserNameField = By.xpath("//input[@name='fullname']");
    private final By password1Field = By.name("password1");
    private final By password2Field = By.name("password2");
    private final By emailField = By.name("email");
    private final By submitButton = By.name("Submit");
    private final By listOfErrors = By.xpath("//*[@class='error jenkins-!-margin-bottom-2']");

    public CreateUserPage(WebDriver driver) {
        super(driver);
    }

    @Step("[CreateUserPage] Send User name")
    public CreateUserPage sendUserName(String userName) {
        getDriver().findElement(userNameField).sendKeys(userName);

        return this;
    }

    @Step("[CreateUserPage] Send User name")
    public CreateUserPage sendUserName(CharSequence userName) {
        getDriver().findElement(userNameField).sendKeys(userName);

        return this;
    }

    @Step("[CreateUserPage] Send User password")
    public CreateUserPage sendPassword(String password) {
        getDriver().findElement(password1Field).sendKeys(password);
        return this;
    }

    @Step("[CreateUserPage] Send User password")
    public CreateUserPage sendPassword(CharSequence password) {
        getDriver().findElement(password1Field).sendKeys(password);
        return this;
    }

    @Step("[CreateUserPage] Send confirm User password")
    public void sendConfirmPassword(String password) {
        getDriver().findElement(password2Field).sendKeys(password);
    }

    @Step("[CreateUserPage] Send User email")
    public void sendEmail(String email) {
        getDriver().findElement(emailField).sendKeys(email);
    }

    @Step("[CreateUserPage] Send User email")
    public CreateUserPage sendEmail(CharSequence email) {
        getDriver().findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("[CreateUserPage] Click Submit button")
    public void clickSubmitButton() {
        getDriver().findElement(submitButton).click();
    }

    @Step("[CreateUserPage] Click create user button")
    public ManageUsersPage clickCreateUserButton() {
        clickSubmitButton();
        return new ManageUsersPage(getDriver());
    }

    @Step("[CreateUserPage] Click create user button")
    public CreateUserPage clickCreateUserButtonNegative() {
        clickSubmitButton();
        return this;
    }

    @Step("[CreateUserPage] Get user name")
    public String getUserNameField() {
        return getDriver().findElement(userNameField).getAttribute("value");
    }

    @Step("[CreateUserPage] Get full user name")
    public String getFullUserNameField() {
        return getDriver().findElement(fullUserNameField).getAttribute("value");
    }

    @Step("[CreateUserPage] Get all errors")
    public List<String> getAllErrors() {

        return getDriver()
                .findElements(listOfErrors)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    @Step("[CreateUserPage] Fill form with users data")
    public CreateUserPage fillForm(UserData user) {
        sendUserName(user.getUserName());
        sendPassword(user.getPassword());
        sendConfirmPassword(user.getConfirmPassword());
        sendEmail(user.getEmail());
        return new CreateUserPage(getDriver());
    }
}
