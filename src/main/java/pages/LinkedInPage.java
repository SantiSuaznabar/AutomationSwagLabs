package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInPage {

    WebDriver driver;
    public LinkedInPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(), 'LinkedIn')]")
    WebElement swagLabsName;

    public boolean swagLabsIsDisplayed()
    {
        boolean swagLabDisplayed = swagLabsName.isDisplayed();
        return swagLabDisplayed;
    }
}
