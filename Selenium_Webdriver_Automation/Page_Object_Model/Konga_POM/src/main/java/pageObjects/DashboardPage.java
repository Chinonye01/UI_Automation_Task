package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    public DashboardPage(WebDriver driver) {
    this.driver = driver;
    }
    //create a web driver object
    private WebDriver driver;

    //use By to locate dashboard elements
    private By computersAndAccessories = By.linkText("Computers and Accessories");
    private By laptops = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/div/section/div[2]/div[2]/ul/li[5]/a");
    private By apple = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/div/section/div[2]/div[2]/ul/li[5]/a/ul/li[1]/a/label");
    private By myAccount = By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div[3]/div[2]/div/a/span");
    private By logoutButton = By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div[3]/div[2]/div/ul/li[7]/a");

    //create a constructor for each field
    public void clickcomputerAndAccessories() {
        driver.findElement(computersAndAccessories).click();
    }
        public void clicklaptops() {
            driver.findElement(laptops).click();
        }
            public void clickapple(){
                driver.findElement(apple).click();
        }
    public void clickmyAccount() {
        driver.findElement(myAccount).click();
    }

    public LoginPage clicklogoutButton() {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }


}
