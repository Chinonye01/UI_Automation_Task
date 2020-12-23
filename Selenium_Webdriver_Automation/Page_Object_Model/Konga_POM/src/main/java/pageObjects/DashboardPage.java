package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage{

    //create a web driver object
    private WebDriver driver;


    public DashboardPage(WebDriver driver) {
        this.driver = driver; }


    //use By to locate dashboard elements
    private By myName = By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div[3]/div[2]/div/ul/li[1]/span");
    By myAccount = By.linkText("My Account");
    By logoutButton = By.linkText("Logout");


    //create a constructor for each field
    public String getMyName() {
        return driver.findElement(myName).getText();
    }


    public void hoverOnMyAcct() throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement myAccountLink = driver.findElement(myAccount);
        actions.moveToElement(myAccountLink).perform();
        Thread.sleep(3000);
    }

    public LoginPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }


}
