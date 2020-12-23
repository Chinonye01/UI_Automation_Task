package compandaccessories;

import dashboard.DashboardTests;
import org.testng.annotations.Test;
import static pageObjects.CompAndAccessoriesPage.compAndAccessoriesPage;

//import static pageObjects.DashboardPage.compAndAccessoriesPage;

public class CompAndAccessoriesTests extends DashboardTests {

@Test//(dependsOnMethods = {"login.LoginTests.testVerifyPageTitle"})
    public void testVerifyAccessories(){
    //click on computers and accessories
   compAndAccessoriesPage.clickcomputerAndAccessories();
    compAndAccessoriesPage.clicklaptops();
    compAndAccessoriesPage.clickapple();
    compAndAccessoriesPage.clickmyAccount();

}

}
