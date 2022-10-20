import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class hmw15 {


    @Test
    public static void  LoginEmptyEmailPasswordTest() {


        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io";
        String password = "te$t$tudent";
        driver.get(url);

//    String url = "https://bbb.testpro.io/registration.php";

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.sendKeys("adenik@yahoo.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");


        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();


        WebElement searchbar = driver.findElement(By.cssSelector("input[type= 'search']"));
        searchbar.sendKeys("Pluto");
        submitButton.click();


        WebElement searchResult = driver.findElement(By.cssSelector("#artistWrapper > div > div > div.item-container > table > tr.song-item.selected > td.title"));
        System.out.println(searchResult.getText());

//        Assert.assertTrue(searchResult.isDisplayed());
        driver.quit();
////
//        driver.quit();
    }
}




