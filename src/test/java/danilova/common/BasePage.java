package danilova.common;

import danilova.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends BaseModel {
    HeaderComponentsPOM header;

    public BasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponentsPOM(driver);
        PageFactory.initElements(driver, this);
    }
}
