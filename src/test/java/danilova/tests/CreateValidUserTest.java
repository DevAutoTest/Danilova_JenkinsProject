package danilova.tests;

import danilova.common.BaseTest;
import danilova.models.UserData;
import danilova.models.UsersFactory;
import danilova.page.HeaderComponentsPOM;
import danilova.page.ManageUsersPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CreateValidUserTest extends BaseTest {

    @Test(dataProvider = "validUsers")
    public void createValidUsersTest(List<UserData> users) {

        for (UserData user : users) {
            new HeaderComponentsPOM(getDriver())
                    .clickManageJenkinsHeader()
                    .clickUserLink()
                    .clickCreateUserButton()
                    .fillForm(user)
                    .clickCreateUserButton();
        }

        List<String> userNames = new ManageUsersPage(getDriver())
                . getLisWebElementsUsers()
                .stream()
                .map(s -> {
                    String trimmed = s.getText().startsWith("/user/") ? s.getText().substring(6) : s.getText();
                    trimmed = trimmed.endsWith("/") ? trimmed.substring(0, trimmed.length() - 1) : trimmed;
                    return trimmed;
                })
                .toList();

        for (UserData user : users) {
            Assert.assertTrue(userNames.contains(user.getUserName()),
                    "User not found: " + user.getUserName());
        }
    }

    @DataProvider(name = "validUsers")
    public Object[][] validUsers() {
        return new Object[][]{
                {List.of(UsersFactory.VALID_USER1,
                        UsersFactory.VALID_USER2,
                        UsersFactory.VALID_USER3,
                        UsersFactory.VALID_USER4,
                        UsersFactory.VALID_USER5,
                        UsersFactory.VALID_USER6,
                        UsersFactory.VALID_USER7,
                        UsersFactory.VALID_USER8,
                        UsersFactory.VALID_USER9,
                        UsersFactory.VALID_USER10)
                }
        };
    }

    @Test(dependsOnMethods = "createValidUsersTest")
    public void searchCreatedUsersTest() {
        List<String> searchResults = new HeaderComponentsPOM(getDriver())
                .clickSearchButton()
                .searchFor("Us");

        Assert.assertEquals(searchResults.size(), 9);
    }

    @Test(dependsOnMethods = "searchCreatedUsersTest")
    public void deleteCreatedUsersTest() {
        new HeaderComponentsPOM(getDriver())
                .clickManageJenkinsHeader()
                .clickUserLink()
                .deleteUser("User");

        List<String> users = new ManageUsersPage(getDriver()).getListUsers();

        Assert.assertEquals(users.size(), 1);
    }
}
