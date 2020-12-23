package dashboard;

import login.LoginTests;
import org.testng.annotations.Test;

public class DashboardTests extends LoginTests {

    @Test(dependsOnMethods = {"login.LoginTests.testVerifyPageTitle"})
    public void hoverOnMyAcct() throws InterruptedException{

        //Click on My Account
       dashboardPage.hoverOnMyAcct();
    }


    @Test(dependsOnMethods = {"login.LoginTests.testVerifyPageTitle","dashboard.DashboardTests.hoverOnMyAcct"})
    public void testSuccessfulLogout()
    {
        dashboardPage.clickLogoutButton();

    }
}
