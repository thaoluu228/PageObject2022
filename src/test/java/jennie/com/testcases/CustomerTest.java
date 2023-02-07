package jennie.com.testcases;

import jennie.com.common.BaseTest;
import jennie.com.pages.CustomerDetailPage;
import jennie.com.pages.CustomerPage;
import jennie.com.pages.DashboardPage;
import jennie.com.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    CustomerDetailPage customerDetail;

    @Test
    public void addNewCustomer() {
        //login
        loginPage = new LoginPage(driver);
        //open Dashboard page
        dashboardPage = loginPage.login("admin@example.com", "123456");
        //open Customer page
        customerPage = dashboardPage.openCustomerPage();
        //add new customer
        customerPage.addNewCustomer();
    }

    @Test
    public void verifyCustomer () {
        loginPage = new LoginPage(driver);
        //open dashboard page
        dashboardPage = loginPage.login("admin@example.com", "123456");
        //open Customer page
        customerPage = dashboardPage.openCustomerPage();
        //verify and delete customer
        customerPage.verifyCustomer();
        customerDetail = customerPage.openCustomerDetail();
        customerDetail.checkCustomerDetails();
        //customerPage.deleteCustomer();

    }
}
