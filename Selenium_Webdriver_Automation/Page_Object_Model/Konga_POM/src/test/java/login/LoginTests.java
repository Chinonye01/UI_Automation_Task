package login;

import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import setUp.setUps;

public class LoginTests extends setUps {

    public static DashboardPage dashboardPage;

    @Test
    public void testVerifyPageTitle() {
        loginPage.clickLoginTab();
        loginPage.enterUsername("okpenonye@gmail.com");
        loginPage.enterPassword("Nonye123+ko");
        System.out.println("The page title is "+loginPage.getPageTitle());

        //Sign in to Konga Successfully
        dashboardPage = loginPage.clickLoginButton();

    }

}
