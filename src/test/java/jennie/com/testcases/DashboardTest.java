package jennie.com.testcases;

import jennie.com.common.BaseTest;
import jennie.com.pages.DashboardPage;
import jennie.com.pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @Test
    public void testTotalInDashboard() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com", "123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.openCustomerPage();
    }
}
