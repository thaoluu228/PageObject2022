package jennie.com.pages;

import jennie.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    private String URL = "https://crm.anhtester.com/admin/authentication";

    By inputEmail = By.id("email");
    By inputPassword = By.id("password");
    By loginButton = By.xpath("//button[normalize-space()='Login']");
    By errMsg = By.xpath("//div[@class='text-center alert alert-danger']");

    public LoginPage(WebDriver _driver){
        driver = _driver;
    }
    public void enterEmail (String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }
    public void enterPassword (String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }
    public void clickLoginButton (){
        driver.findElement(loginButton).click();
    }
    public void verifyErrMsg (){
        Assert.assertTrue(driver.findElement(errMsg).isDisplayed(),"Fail, error message is not displayed");
        Assert.assertEquals(driver.findElement(errMsg).getText(), "Invalid email or password");
    }
    public void login (String email, String password) {
        driver.get(URL);
        enterEmail(email);
        enterPassword(password);
        WebUI.sleep(2);
        clickLoginButton();
        WebUI.sleep(2);
        WebUI.checkElementExist(driver, "//li[@class='menu-item-dashboard active']/a//span");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='menu-item-dashboard active']/a//span")).getText(),"Dashboard");
    }

    public void loginFail (String email, String password) {
        driver.get(URL);
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        WebUI.sleep(2);
        verifyErrMsg();
        WebUI.sleep(2);
    }

}
