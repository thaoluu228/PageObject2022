package jennie.com.pages;

import jennie.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProjectPage {
    private String PROJECT = "Jennie project";
    private WebDriver driver;
    public ProjectPage (WebDriver _driver){
        driver = _driver;
    }
    By newProjectButton = By.xpath("//a[normalize-space()='New Project']");
    By projectName = By.id("name");
    By customer = By.xpath("//button[@class='btn dropdown-toggle bs-placeholder btn-default']/div");
    By customerSearch = By.xpath("(//div[@class='dropdown-menu open']//input)[1]");
    By customerResult = By.xpath("(//div[@class='inner open'])[1]");
    By saveButton = By.xpath("//button[normalize-space()='Save']");
    By searchProject = By.xpath("//input[@class='form-control input-sm']");
    By getProject = By.xpath("//tbody/tr[1]/td[2]/a");
    public void addNewProject(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(newProjectButton).click();
        WebUI.waitForPageLoaded(driver);
        driver.findElement(projectName).sendKeys(PROJECT);
        driver.findElement(customer).click();
        driver.findElement(customerSearch).sendKeys("Jennie", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(customerResult).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@id='billing_type']")));
        select.selectByVisibleText("Fixed Rate");
        WebUI.sleep(1);
        driver.findElement(saveButton).click();
        WebUI.sleep(1);
        WebUI.waitForPageLoaded(driver);
        //verify message success
        Assert.assertTrue(WebUI.checkElementExist(driver,"//span[@class='alert-title']" ));
        System.out.println(driver.findElement(By.xpath("//span[@class='alert-title']")).getText());
    }

    public void verifyProject(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(searchProject).sendKeys(PROJECT);
        WebUI.sleep(1);
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, getProject);
        String getProjectName = driver.findElement(getProject).getText();
        Assert.assertEquals(getProjectName, PROJECT, "Fail. Project name doesn't match'");
    }
}
