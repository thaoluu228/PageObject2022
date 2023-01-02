package jennie.com.testcases;

import jennie.com.common.BaseTest;
import jennie.com.pages.CustomerPage;
import jennie.com.pages.DashboardPage;
import jennie.com.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void addNewCustomer() {
        //login
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com", "123456");
        //open Customer page
        dashboardPage = new DashboardPage(driver);
        dashboardPage.openCustomerPage();
        //add new customer
        customerPage = new CustomerPage(driver);
        customerPage.addNewCustomer();
    }

    @Test
    public void verifyAndDeleteCustomer () {
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com", "123456");

        //open Customer page
        dashboardPage = new DashboardPage(driver);
        dashboardPage.openCustomerPage();

        //verify and delete customer
        customerPage = new CustomerPage(driver);
        customerPage.verifyCustomer();
        customerPage.deleteCustomer();

    }
}
