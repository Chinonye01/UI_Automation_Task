package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    //import selenium driver
    private WebDriver driver;

    //import chrome driver
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        //fetch URL
        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");

        //make the page wait a while for URL to load
        Thread.sleep(5000);

        //maximize page
        driver.manage().window().maximize();

        //fetch page title
        System.out.println(driver.getTitle());

        //make the page to wait a while for URL to fully load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //locate email field
        driver.findElement(By.id("username")).sendKeys("chinonyelum");

        //locate password field
        driver.findElement(By.id("password")).sendKeys("Chinonyelum123");

        //locate button field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();

    }


    @Test(priority = 0)
    public void testSuccessfulLogin(){
        if (driver.getCurrentUrl ().contains ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed"))
            //Pass
            System.out.println ("The Page URL contains /app/feed");
        else
            //Fail
            System.out.println ("The Page URL does not contain /app/feed");
    }
    @Test(priority = 1)
    public void testLogout() throws InterruptedException {
        //click on the profile button
        driver.findElement (By.xpath ("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button")).click ();
        Thread.sleep (2000);
        //click on the logout button
        driver.findElement (By.xpath ("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/div/div/a[3]/p")).click ();
        //printout response based on status
        if(driver.getCurrentUrl ().contains ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login\""))
            //Pass
            System.out.println ("The Login page URL contains /login");
        else
            //Fail
            System.out.println ("The Login URL does not contain /login");
    }
    @Test(priority = 1)
    public void testNegativeLogin(){
        driver.findElement (By.id ("username")).sendKeys ("invalidUsername");
        driver.findElement (By.id ("password")).sendKeys ("admin123.");
        driver.findElement (By.xpath ("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click ();
        String expectedErrorMessage = "Login Failed: Invalid username or password";
        String actualErrorMessage = driver.findElement(By.xpath ("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/div[4]/div/div/p")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }



        //close browser
        public static void main(String[] args) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setUp();
    }

        /* quit browser */

        @AfterClass
                public void closeBrowser () throws InterruptedException {
            Thread.sleep(1000);
            driver.quit();
        }





}
