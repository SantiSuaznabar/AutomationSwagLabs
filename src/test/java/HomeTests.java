import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.*;
import utilities.DriverManager;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeTests extends BaseTest {

    @Test @Ignore
    public void verifyCartButtonNumberIsAdded(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        Assert.assertEquals( "1", homepage.getCartIconText());
        homepage.clickOnRemoveSauceLabsBackPackToCartButton();
    }
    @Test @Ignore
    public void verifyCartButtonNumberIsBlankWhereThereIsNotProductsInTheCart(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnRemoveSauceLabsBackPackToCartButton();
        Assert.assertEquals( "", homepage.getCartIconText());
    }

    @Test
    public void verifyOpenFacebook() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnFacebookBtn();

        List<String> tabs = new ArrayList<String>(DriverManager.getDriver().driver.getWindowHandles());
        DriverManager.getDriver().driver.switchTo().window(tabs.get(1));

        FBpage fbPage = new FBpage(DriverManager.getDriver().driver);
        DriverManager.getDriver().driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(fbPage.swagLabsIsDisplayed());
        DriverManager.getDriver().driver.close();
    }

    @Test
    public void verifyOpenTwitter() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnTwitterBtn();

        List<String> tabs = new ArrayList<String>(DriverManager.getDriver().driver.getWindowHandles());
        DriverManager.getDriver().driver.switchTo().window(tabs.get(1));
        TwitterPage tweetPage = new TwitterPage(DriverManager.getDriver().driver);
        DriverManager.getDriver().driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(tweetPage.swagLabsIsDisplayed());
        DriverManager.getDriver().driver.close();
    }

    @Test
    public void verifyOpenLinkedIn() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnLinkedInBtn();

        List<String> tabs = new ArrayList<String>(DriverManager.getDriver().driver.getWindowHandles());
        DriverManager.getDriver().driver.switchTo().window(tabs.get(1));
        LinkedInPage linkedInpage = new LinkedInPage(DriverManager.getDriver().driver);
        DriverManager.getDriver().driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(linkedInpage.swagLabsIsDisplayed());
        DriverManager.getDriver().driver.close();
    }
}
