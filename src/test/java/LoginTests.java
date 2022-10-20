import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
<<<<<<< Updated upstream

public class LoginTests {
=======
>>>>>>> Stashed changes

public class LoginTests {
    @Test
    public static void  LoginEmptyEmailPasswordTest() {



        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
<<<<<<< Updated upstream

        String url = "https://bbb.testpro.io/";
=======
        String url = "https://bbb.testpro.io";
>>>>>>> Stashed changes
        driver.get(url);

//    String url = "https://bbb.testpro.io/registration.php";

        WebElement emailField= driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("adenik@yahoo.com");

        WebElement passwordField= driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton= driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();


        WebElement searchField= driver.findElement(By.cssSelector("[type= 'search']"));
        searchField.sendKeys("Pluto");
        submitButton.click();

        WebElement searchResult = driver.findElement(By.cssSelector("#artistWrapper > div > div > div.item-container > table > tr.song-item.selected > td.title"));
        System.out.println(searchResult.getText());


        Assert.assertTrue(searchResult.isDisplayed());
        driver.quit();
    }
}

