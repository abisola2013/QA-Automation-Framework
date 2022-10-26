
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework16 {
    @Test

    public static void Homework16() throws InterruptedException {

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.sendKeys("adenik@yahoo.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebElement playList = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        playList.click();

        WebElement newPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
        newPlaylist.click();
        Thread.sleep(2000);

        WebElement searchBar=driver.findElement(By.xpath("//*[@class=\"create\"]//*[@type=\"text\"]"));
        searchBar.sendKeys("Abby");
        searchBar.click();
        Thread.sleep(2000);

        WebElement newPlaylistResult =driver.findElement(By.xpath("//*[@href=\"#!/playlist/25250\"]"));
        System.out.println(newPlaylistResult.getText());

        Assert.assertTrue(newPlaylistResult.isDisplayed());

        driver.quit();

    }
}