package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import setUp.setUps;


public class LoginPage extends setUps {

    //create constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //create a web driver object
    private WebDriver driver;

    //using By as a locator to identify the login fields
    private By loginTab = By.xpath("//*[@id=\"app-content-wrapper\"]/nav/div[3]/div/div[1]/div[1]/a");
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"mainContent\"]/div/div/div/div[1]/form/div[3]/button");

    //create a constructor for each field
    public void clickloginTab(){
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

    public DashboardPage clickloginButton(){
        //find the login button
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }



}
