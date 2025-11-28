package danilova.tests;

import danilova.common.BaseTest;
import danilova.page.HeaderComponentsPOM;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserConfigurePOMTest extends BaseTest {

    final String oldName = "admin";
    final String newName = "New full name";

    @Test
    void getFullNameAccountPageTest() {
        String actualName = new HeaderComponentsPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .getFullName();

        Assert.assertEquals(actualName, oldName);
    }

    @Test
    void getFullNameStatusPageTest() {
        String actualName = new HeaderComponentsPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuStatus(oldName)
                .getFullUserName();

        Assert.assertEquals(actualName, oldName);
    }

    @Test(dependsOnMethods = "getFullNameAccountPageTest")
    void renameFullNameTest() {
        String expectedName = new HeaderComponentsPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .clearFullName()
                .sendFullName(newName)
                .clickApply()
                .getFullName();

        String actualName = new HeaderComponentsPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .getFullName();
        Assert.assertEquals(actualName, expectedName);
    }

    @Test(dependsOnMethods = "renameFullNameTest")
    void getStatusFullNameTest() {
        String actualName = new HeaderComponentsPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuStatus(newName)
                .getFullUserName();

        Assert.assertEquals(actualName, newName);
    }

    @Test(dependsOnMethods = "getStatusFullNameTest")
    void renameByDefaultAdminNameTest() {
        String expectedName = new HeaderComponentsPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .clearFullName()
                .sendFullName(oldName)
                .clickApply()
                .getFullName();

        String actualName = new HeaderComponentsPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .getFullName();
        Assert.assertEquals(actualName, expectedName);
    }
}