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
        driver.get("https://monosnap.com/");

        //make the page wait a while for URL to load
        Thread.sleep(5000);

        //maximize page
        driver.manage().window().maximize();

        //fetch page title
        System.out.println(driver.getTitle());

        //make the page to wait a while for URL to fully load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //click accept cookies
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[3]/div[2]")).click();


        //click on the signin button on the homepage
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/div/div[2]/div[3]")).click();

        //locate email field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[1]")).sendKeys("okpenonye@gmail.com");

        //locate password field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[2]")).sendKeys("Nonye123+m");


        //locate button field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/button")).click();


        //to click on the OK button

        driver.findElement(By.xpath("//*[@id=\"store\"]/div[1]/div/div[2]/div[2]/div[1]/div/button")).click();

    }


    @Test(priority = 0)
    public void testSuccessfulLogin() {
        if (driver.getCurrentUrl().contains("https://monosnap.com/"))
            //Pass
            System.out.println("The Page URL contains monosnap");
        else
            //Fail
            System.out.println("The Page URL does not contain monosnap");
    }

    @Test(priority = 1)
    public void testLogout() throws InterruptedException {
        //click on the settings
        driver.findElement(By.xpath("//*[@id=\"store\"]/div[4]/div/div[1]/div/div[3]/div[3]")).click();
        Thread.sleep(1000);
        //click on the logout button
        driver.findElement(By.xpath("//*[@id=\"store\"]/div[4]/div/div[1]/div/div[1]/div[2]")).click();

        //printout response based on status
        if (driver.getCurrentUrl().contains("https://monosnap.com/"))
            //Pass
            System.out.println("The Login page URL contains monosnap");
        else
            //Fail
            System.out.println("The Login URL does not contain monosnap");


    }

    @Test(priority = 1)
    public void testNegativeLogin() {

        //click on sign in
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/div[2]/div[3]/span")).click();

        //click on settings

        driver.findElement(By.xpath("//*[@id=\"store\"]/div[3]/div/div[1]/div/div[3]/div[2]")).click();

        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/div[2]/div[3]/span")).click();

        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/div[2]/div[3]/span")).click();

        //locate email field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[1]")).sendKeys("InvalidUsername");

        //locate password field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[2]")).sendKeys("123456");


        //locate button field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/button")).click();

        String expectedErrorMessage = "div";
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div")).getTagName();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }


    //close browser
    public static void main(String[] args) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setUp();
    }

    /* quit browser */

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
