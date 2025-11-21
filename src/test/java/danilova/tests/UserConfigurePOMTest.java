package danilova.tests;

import danilova.common.BaseTest;
import danilova.page.HeaderComponentPOM;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserConfigurePOMTest extends BaseTest {

    final String oldName = "admin";
    final String newName = "New full name";

    @Test
    public void testAccessUserAccountFromHome() {
        final String expUserName = "admin";

        String actUserName = new HeaderComponentPOM(getDriver())
                .clickOverAccountIcon()
                .getFullUserName();

        Assert.assertEquals(actUserName, expUserName);
    }


    @Test
    void getFullName() {
        String actualName = new HeaderComponentPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .getFullName();

        Assert.assertEquals(actualName, oldName);
    }

    @Test(dependsOnMethods = "getFullName")
    void renameFullName()  {
        String expectedName = new HeaderComponentPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .clearFullName()
                .sendFullName(newName)
                .clickApply()
                .getFullName();

        String actualName = new HeaderComponentPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .getFullName();
        Assert.assertEquals(actualName, expectedName);
    }

    @Test(dependsOnMethods = "renameFullName")
    void getStatusFullName()  {
        String actualName = new HeaderComponentPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuStatus(newName)
                .getFullUserName();

        Assert.assertEquals(actualName, newName);
    }

    @Test(dependsOnMethods = "getStatusFullName")
    void renameByDefaultAdminName()  {
        String expectedName = new HeaderComponentPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .clearFullName()
                .sendFullName(oldName)
                .clickApply()
                .getFullName();

        String actualName = new HeaderComponentPOM(getDriver())
                .hoverOverAccountIcon()
                .clickDropDownMenuAccount()
                .getFullName();
        Assert.assertEquals(actualName, expectedName);
    }

}
