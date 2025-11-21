package danilova.tests;

import danilova.models.UsersFactory;
import danilova.page.HeaderComponentPOM;
import danilova.page.ManageUsersPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import danilova.common.BaseTest;
import danilova.page.CreateUserPage;
import danilova.testUtils.AsciiUtils;
import danilova.testUtils.GetRandomUtils;

import java.util.List;

public class CreateUserPOMTest extends BaseTest {

    @Test
    public void createValidUser() {
        new HeaderComponentPOM(getDriver()).clickManageJenkinsHeader()
                .clickUserLink()
                .clickCreateUserButton()
                .fillForm(UsersFactory.VALID_USER);
        ManageUsersPage usersPage = new CreateUserPage(getDriver()).clickCreateUserButton();

        List<String> usersName = usersPage.getListUsers().stream()
                .map(s -> {
                    String trimmed = s.getText().startsWith("/user/") ? s.getText().substring(6) : s.getText();  // убрали "/user/"
                    trimmed = trimmed.endsWith("/") ? trimmed.substring(0, trimmed.length() - 1) : trimmed;
                    return trimmed;
                })
                .toList();

        Assert.assertEquals(usersName.get(1), UsersFactory.VALID_USER.getUserName(), "error");
    }

    @Test
    public void createInvalidFullUserNameTest() {
        final String expectedErrorMessageForEmptyNameField = "\"\" is prohibited as a username for security reasons.";
        final String expectedErrorMessageForEmptyFullNameField = "\"\" is prohibited as a full name for security reasons.";

        final String testData = "";

        List<String> actualErrors = new HeaderComponentPOM(getDriver())
                .clickManageJenkinsHeader()
                .clickUserLink()
                .clickCreateUserButton()
                .sendUserName(testData.repeat(GetRandomUtils.getRandomInteger()))
                .clickCreateUserButtonNegative()
                .getAllErrors();

        Assert.assertEquals(actualErrors.get(0), expectedErrorMessageForEmptyNameField);
        Assert.assertEquals(actualErrors.get(3), expectedErrorMessageForEmptyFullNameField);
    }

    @Test
    public void createInvalidUserNameTest() {
        final String expectedErrorMessage = "User name must only contain alphanumeric characters, underscore and dash";
        final CharSequence testData = AsciiUtils.getRandomInvalidAsciiCharForNameFieldsValidationUtil();

        List<String> actualErrors = new HeaderComponentPOM(getDriver())
                .clickManageJenkinsHeader()
                .clickUserLink()
                .clickCreateUserButton()
                .sendUserName(testData)
                .clickCreateUserButtonNegative()
                .getAllErrors();

        String userName = new CreateUserPage(getDriver()).getUserNameField();
        String fullName = new CreateUserPage(getDriver()).getFullUserNameField();

        Assert.assertEquals(actualErrors.get(0), expectedErrorMessage);
        Assert.assertEquals(userName, fullName);
    }

    @Test
    public void createEmptyPasswordTest() {
        final String expectedErrorMessage = "Password is required";

        List<String> actualErrors = new HeaderComponentPOM(getDriver())
                .clickManageJenkinsHeader()
                .clickUserLink()
                .clickCreateUserButton()
                .sendPassword("")
                .clickCreateUserButtonNegative()
                .getAllErrors();

        Assert.assertEquals(actualErrors.get(1), expectedErrorMessage);
        Assert.assertEquals(actualErrors.get(2), expectedErrorMessage);
    }

    @Test
    public void createNotMatchedPasswordTest() {
        final String expectedErrorMessage = "Password didn't match";

        List<String> actualErrors = new HeaderComponentPOM(getDriver())
                .clickManageJenkinsHeader()
                .clickUserLink()
                .clickCreateUserButton()
                .sendPassword(AsciiUtils.getRandomAsciiCharUtil())
                .clickCreateUserButtonNegative()
                .getAllErrors();

        Assert.assertEquals(actualErrors.get(1), expectedErrorMessage);
        Assert.assertEquals(actualErrors.get(2), expectedErrorMessage);
    }

    @Test
    public void createInvalidEmailTest() {
        final String expectedErrorMessage = "Invalid e-mail address";

        List<String> actualErrors = new HeaderComponentPOM(getDriver())
                .clickManageJenkinsHeader()
                .clickUserLink()
                .clickCreateUserButton()
                .sendEmail(AsciiUtils.getRandomInvalidAsciiCharForEmailUtil())
                .clickCreateUserButtonNegative()
                .getAllErrors();

        Assert.assertEquals(actualErrors.get(4), expectedErrorMessage);
    }
}
