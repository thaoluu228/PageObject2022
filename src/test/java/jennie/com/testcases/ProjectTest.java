package jennie.com.testcases;

import jennie.com.common.BaseTest;
import jennie.com.pages.DashboardPage;
import jennie.com.pages.LoginPage;
import jennie.com.pages.ProjectPage;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectPage projectPage;

    @Test
    public void addNewProject() throws Exception {
        loginPage = new LoginPage(driver);
        //open dashboard page
        dashboardPage = loginPage.login("admin@example.com", "123456");
        //open project page
        projectPage = dashboardPage.openProjectPage();
        projectPage.addNewProject();
    }
    @Test
    public void verifyProject() throws Exception {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login("admin@example.com", "123456");
        projectPage = dashboardPage.openProjectPage();
        projectPage.verifyProject();
    }

}
