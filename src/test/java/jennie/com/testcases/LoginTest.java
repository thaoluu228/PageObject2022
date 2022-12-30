package jennie.com.testcases;

import jennie.com.common.BaseTest;
import jennie.com.pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginTestSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com", "123456");
    }
    @Test
    public void loginTestFail()throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginFail("admin@example.co", "123456");
    }
}
