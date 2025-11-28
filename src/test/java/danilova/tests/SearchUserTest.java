package danilova.tests;

import danilova.common.BaseTest;
import danilova.page.HeaderComponentsPOM;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchUserTest extends BaseTest {

    @Test
    public void searchAdminUserTest() {
        String expectedUser = "admin";
        String actualUser = new HeaderComponentsPOM(getDriver())
                .clickSearchButton()
                .searchByUser("admin")
                .getFullUserName();
        Assert.assertEquals(actualUser, expectedUser);
    }
}
