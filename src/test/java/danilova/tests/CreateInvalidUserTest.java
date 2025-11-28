package danilova.tests;

import danilova.models.UsersFactory;
import danilova.page.HeaderComponentsPOM;
import org.testng.Assert;
import org.testng.annotations.Test;
import danilova.common.BaseTest;
import danilova.page.CreateUserPage;
import danilova.testUtils.AsciiUtils;
import danilova.testUtils.GetRandomUtils;

import java.util.List;

public class CreateInvalidUserTest extends BaseTest {

    @Test
    public void createDuplicateValidUserTest() {
        String expectedError = "User name is already taken";
        new HeaderComponentsPOM(getDriver())
                .clickManageJenkinsHeader()
                .clickUserLink()
                .clickCreateUserButton()
                .fillForm(UsersFactory.VALID_USER1)
                .clickCreateUserButton();

        List<String> actualErrors = new HeaderComponentsPOM(getDriver())
                .clickManageJenkinsHeader()
                .clickUserLink()
                .clickCreateUserButton()
                .fillForm(UsersFactory.VALID_USER1)
                .clickCreateUserButtonNegative()
                .getAllErrors();
        Assert.assertEquals(actualErrors.get(0), expectedError);
    }

    @Test
    public void createInvalidFullUserNameTest() {
        final String expectedErrorMessageForEmptyNameField = "\"\" is prohibited as a username for security reasons.";
        final String expectedErrorMessageForEmptyFullNameField = "\"\" is prohibited as a full name for security reasons.";

        final String testData = "";

        List<String> actualErrors = new HeaderComponentsPOM(getDriver())
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

        List<String> actualErrors = new HeaderComponentsPOM(getDriver())
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

        List<String> actualErrors = new HeaderComponentsPOM(getDriver())
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

        List<String> actualErrors = new HeaderComponentsPOM(getDriver())
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

        List<String> actualErrors = new HeaderComponentsPOM(getDriver())
                .clickManageJenkinsHeader()
                .clickUserLink()
                .clickCreateUserButton()
                .sendEmail(AsciiUtils.getRandomInvalidAsciiCharForEmailUtil())
                .clickCreateUserButtonNegative()
                .getAllErrors();

        Assert.assertEquals(actualErrors.get(4), expectedErrorMessage);
    }
}
