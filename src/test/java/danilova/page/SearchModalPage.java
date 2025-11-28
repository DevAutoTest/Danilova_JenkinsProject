package danilova.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import danilova.common.BaseModel;

import java.util.List;

public class SearchModalPage extends BaseModel {

    private final By searchIcon = By.xpath("//input[@id = 'command-bar']");

    public SearchModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("[SearchModalPage] Search for text return List")
    public List<String> searchFor(String searchText) {
        getDriver().findElement(searchIcon).sendKeys(searchText);

        return getDriver().findElements(By.xpath(String.format("//div[@id='search-results']//a[contains(normalize-space(.), '%s')]", searchText)))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    @Step("[SearchModalPage] Search for text return StatusComponentUserPage")
    public StatusComponentUserPage searchByUser(String searchText) {
        WebElement input = getDriver().findElement(searchIcon);
        input.sendKeys(searchText);
        getDriver().findElements(By.xpath(String.format("//div[@id='search-results']//a[contains(normalize-space(.), '%s')]", searchText)))
                .stream()
                .filter(s -> s.getText().equals(searchText))
                .findFirst()
                .ifPresent(WebElement::click);
        return new StatusComponentUserPage(getDriver());
    }
}
