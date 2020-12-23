package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import setUp.setUps;


public class LoginPage extends setUps {

    //create a web driver object
    private WebDriver driver;

    //create constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    //using By as a locator to identify the login fields
    private By loginTab = By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/nav/div[2]/div/div[3]/div[2]/a");
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button");

    //create a constructor for each field
    public void clickLoginTab(){
        //find the first login button on the home page
        driver.findElement(loginTab).click();
    }

    public void enterUsername(String uName){
        //find the username element and enter the username
        driver.findElement(username).sendKeys(uName);

    }

    public void enterPassword(String pwd){
        //find the password element and enter the username
        driver.findElement(password).sendKeys(pwd);

    }

    public DashboardPage clickLoginButton(){
        //find the login button
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }
}
