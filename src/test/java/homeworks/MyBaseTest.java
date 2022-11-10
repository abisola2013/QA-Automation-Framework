package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class MyBaseTest {
//this is our own base test, I created a new package (homeworks) so all your works would be
//    in one package
public WebDriver driver;
    String url;
    public WebDriverWait wait;
    Actions actions;


    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "Untitled/chromedriver");
        }


    }

    @BeforeMethod
    // Send a parameter for 'baseURL' specified in XML
    @Parameters({"baseURL"})
    // Make baseURL parameter optional, if it is null, then set it to something)
    public void launchBrowser(@Optional String baseURL) {
        if (baseURL == null)
            baseURL ="https://bbb.testpro.io";
        driver = new ChromeDriver();
        actions = new Actions(driver);
        // Make webdriver load the pages REALLY slow
//        WebDriver augmentedDriver = new Augmenter().augment(driver);
//        ChromiumNetworkConditions networkConditions = new ChromiumNetworkConditions();
//        networkConditions.setDownloadThroughput(100 * 1024);
//        networkConditions.setUploadThroughput(500 * 1024);
//        networkConditions.setLatency(Duration.ofMillis(5000));
//        ((HasNetworkConditions) augmentedDriver).setNetworkConditions(networkConditions);
        // (comment out above lines to remove throttling)

        // Wait for an element to show up for max of X seconds
        // implicitlyWait(Duration.ofSeconds(60) will wait for UP to 60 seconds
        // if element comes up after 1 second, it will move on
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // thread.sleep(60000) -- will wait 60s always
        url = baseURL;
        driver.get(url);

    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public void clickSubmitBtn() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }
//    lets add a string as a parameter for the provide email method


    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("password");
    }
//    lets add a string as a parameter for the provide password method
//    in this way, we could just call the method, and add our valid email/password

    @DataProvider(name="invalidCredentials")
    public Object[][] getCredentials(){

        return new Object[][] {
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"", ""}
        };
    }

    public void login( ){
        provideEmail("adenik@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
    // this is good

}
