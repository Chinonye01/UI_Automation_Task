package login;

import Setup.SetupTests;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;

public class LoginTests extends SetupTests {
    //testNG annotation

@Test
    //this class extends to the SetupTests
    public void testLogin() throws InterruptedException {

    Thread.sleep(1000);
    String username = "Admin";
    loginPage.enterUsername(username);
    loginPage.enterUserPassword("admin123");


//handler for dashboard page

    DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.clickWelcomeAdmin();
        loginPage = dashboardPage.clickLogout();

    }

}
