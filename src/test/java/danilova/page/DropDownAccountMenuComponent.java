package danilova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDownAccountMenuComponent extends HeaderComponentPOM{

    public DropDownAccountMenuComponent(WebDriver driver) {
        super(driver);
    }

    public AccountComponentUserPage clickDropDownMenuAccount(){
        driver.findElement(By.xpath("//a[contains(@class, 'jenkins-dropdown__item') and normalize-space(.)='Account']")).click();
        return new AccountComponentUserPage(driver);
    }

    public StatusComponentUserPage clickDropDownMenuStatus(String user){
       By xpath = By.xpath(String.format("//a[contains(@class, 'jenkins-dropdown__item') and normalize-space(.)='%s']", user));
        for (int i = 0; i < 3; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
                return new StatusComponentUserPage(driver);
            } catch (org.openqa.selenium.StaleElementReferenceException e) {

            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
        return new StatusComponentUserPage(driver);
    }
}
