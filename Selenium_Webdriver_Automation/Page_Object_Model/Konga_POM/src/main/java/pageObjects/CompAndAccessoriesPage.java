package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CompAndAccessoriesPage {
    //create a web driver object
    private WebDriver driver;

    public static CompAndAccessoriesPage compAndAccessoriesPage;

    public CompAndAccessoriesPage(WebDriver driver) { this.driver = driver; }

    //use By to locate Computer And Accessories elements
    private By computersAndAccessories = By.linkText("Computers and Accessories");
    private By laptops = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/div/section/div[2]/div[2]/ul/li[5]/a");
    private By apple = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/div/section/div[2]/div[2]/ul/li[5]/a/ul/li[1]/a/label");
    private By myAccount = By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/nav/div[2]/div/div[3]/div[2]/div/a/span");

    //create a constructor for each field
    public CompAndAccessoriesPage clickcomputerAndAccessories() {
        driver.findElement(computersAndAccessories).click();
        return new CompAndAccessoriesPage(driver);
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
}
