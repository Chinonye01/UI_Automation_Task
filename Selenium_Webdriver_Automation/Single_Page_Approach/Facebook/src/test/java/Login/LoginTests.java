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
        driver.get("https://www.facebook.com/?stype=lo&jlou=AfdsDb165lOaShnr-GwRxOG9U03b6ma0VetYF_717EO_mylNHhP1WbAHvf4F5hx7g-CWtsq5LhKvYoFF-WShC6rajpkbDytx_CrOXX_2KufgNA&smuh=7773&lh=Ac-zj0Em6--6y6XOP3s");

        //make the page wait a while for URL to load
        Thread.sleep(5000);

        //maximize page
        driver.manage().window().maximize();

        //fetch page title
        System.out.println(driver.getTitle());

        //make the page to wait a while for URL to fully load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //locate email field
        driver.findElement(By.id("email")).sendKeys("2347051352704");

        //locate password field
        driver.findElement(By.id("pass")).sendKeys("Nonye123+f");

        //locate button field
        driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();


    }


    @Test(priority = 1)
    public void testSuccessfulLogin(){
        if (driver.getCurrentUrl ().contains ("https://www.facebook.com/"))
            //Pass
            System.out.println ("The Page URL contains facebook");
        else
            //Fail
            System.out.println ("The Page URL does not contain facebook");
    }
    @Test(priority = 2)
    public void testLogout() throws InterruptedException {

        //click on the account button
        driver.findElement (By.xpath ("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[1]/span/div/div[1]/img")).click ();

        Thread.sleep (2000);

        //click on the logout button
        driver.findElement (By.xpath ("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")).click ();

        //printout response based on status
        if(driver.getCurrentUrl ().contains ("https://www.facebook.com/"))
            //Pass
            System.out.println ("The Login page URL contains facebook");
        else
            //Fail
            System.out.println ("The Login URL does not contain facebook");
    }
    @Test(priority = 3)
    public void testNegativeLogin(){

        driver.findElement(By.id("email")).sendKeys("invalidUsername");


        driver.findElement(By.id("pass")).sendKeys("admin123.");


        driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();

        String expectedErrorMessage = "Invalid username or password";
        String actualErrorMessage = driver.findElement(By.xpath ("//*[@id=\"error_box\"]/div[2]")).getText();
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
