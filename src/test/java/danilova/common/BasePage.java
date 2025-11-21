package danilova.common;

import danilova.page.*;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BaseModel {
    HeaderComponentPOM header;

    public BasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponentPOM(driver);
    }
}
