package danilova.tests;

import danilova.common.BaseTest;
import danilova.page.HeaderComponentPOM;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserConfigurePOMTest extends BaseTest {

    final String oldName = "admin";
    final String newName = "New full name";

    @Test
    void getFullName() {
        String actualName = new HeaderComponentPOM(getDriver())
                .clickUserHeaderMenu()
                .clickAccount()
                .getFullName();

        Assert.assertEquals(actualName, oldName);
    }

    @Test(dependsOnMethods = "getFullName")
    void renameFullName() {
        String expectedName = new HeaderComponentPOM(getDriver())
                .clickUserHeaderMenu()
                .clickAccount()
                .clearFullName()
                .sendFullName(newName)
                .clickApply()
                .getFullName();

        String actualName = new HeaderComponentPOM(getDriver())
                .clickUserHeaderMenu()
                .clickAccount()
                .getFullName();
        Assert.assertEquals(actualName, expectedName);
    }

    @Test(dependsOnMethods = "renameFullName")
    void getStatusFullName() {
        String actualName = new HeaderComponentPOM(getDriver())
                .clickUserHeaderMenu()
                .clickStatus()
                .getFullUserName();

        Assert.assertEquals(actualName, newName);
    }

    @Test(dependsOnMethods = "getStatusFullName")
    void renameByDefaultAdminName() {
        String expectedName = new HeaderComponentPOM(getDriver())
                .clickUserHeaderMenu()
                .clickAccount()
                .clearFullName()
                .sendFullName(oldName)
                .clickApply()
                .getFullName();

        String actualName = new HeaderComponentPOM(getDriver())
                .clickUserHeaderMenu()
                .clickAccount()
                .getFullName();
        Assert.assertEquals(actualName, expectedName);
    }

}
