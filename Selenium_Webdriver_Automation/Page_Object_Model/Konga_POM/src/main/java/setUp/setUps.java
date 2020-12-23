package setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class setUps {
    //create a web driver object
    private WebDriver driver;


    //create login object
    public static LoginPage loginPage;


    @BeforeTest

    public void setUp() {
        //Browser set up for Chrome
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        //maximize the window
        driver.manage().window().maximize();

        //Visit the URL Konga
        driver.get("https://www.konga.com/");
        //let the browser generally wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //instantiate Login page after launching browser
        loginPage = new LoginPage(driver);

    }

    @AfterTest
    public void cleanUp() throws InterruptedException {
        //delete cookies
        driver.manage().deleteAllCookies();
        Thread.sleep(1000);
        driver.quit();
    }
}


