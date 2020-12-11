package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;


public class SetupTests {
    //create a Web driver object
    private WebDriver driver;

    //create login Page object
    protected LoginPage loginPage;

    @BeforeTest

    public void setUp() {

        //Selenium Web driver needs this executable in order to know which web browser to run my test
        //Browser set up for Chrome

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();

        /*Browser set up for firefox
        System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
         */

        //maximize window size
        driver.manage().window().maximize();

        //launch the application
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //initiate login page after launching the browser
        loginPage = new LoginPage(driver);

    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();


    }



}
