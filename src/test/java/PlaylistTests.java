import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest {
        WebDriver driver;
        String url = "https://bbb.testpro.io/";



@Test(priority = 0)
        public void addSongToPlaylist() throws InterruptedException {
        //login
        provideEmail();
        providePassword();
        clickSubmitBtn();
        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.get(url);

        WebElement allSongs = driver.findElement(By.xpath("//a[@class='songs active'] "));
        allSongs.click();
        Thread.sleep(2000);
        WebElement title = driver.findElement(By.xpath("//*[text()='Algorithms']"));
        title.click();
        Thread.sleep(2000);
        WebElement addTo = driver.findElement(By.xpath("//button[@title='Add selected songs to…']"));
        addTo.click();
        Thread.sleep(2000);
        WebElement playList = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[@class='favorites']"));
        playList.click();
        Thread.sleep(2000);

}


}





