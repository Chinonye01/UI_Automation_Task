package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;

    //create a constructor

    public DashboardPage(WebDriver driver) {

        this.driver = driver;
    }
     //locate elements

    private final By welcomeAdmin = By.cssSelector("#branding a:nth-child(2)");
    private final By logOut = By.linkText("Logout");

    //functions to interact with the elements

    public void clickWelcomeAdmin() throws InterruptedException {

        //wait for 10secs
        Thread.sleep(1000);
        driver.findElement(welcomeAdmin).click();
    }

    public LoginPage clickLogout() throws InterruptedException {
        //wait for 3secs
        Thread.sleep(3000);
        driver.findElement(logOut).click();
        return new LoginPage(driver);

    }

}
