package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19A extends MyBaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        login();
        clickSubmitBtn();
        myPlaylist();
        delPlaylist();
        Assert.assertEquals(getConfirmationTxt(), "Deleted playlist");


    }


    private String getConfirmationTxt() {
        return driver.findElement(By.xpath("//p[@class='msg']")).getText();

    }


    private void myPlaylist() throws InterruptedException {
        WebElement myPlaylist = driver.findElement(By.xpath("  //section[@id='playlists']//a[@class='active']"));
        myPlaylist.click();
        Thread.sleep(5000);
    }
    private void delPlaylist() throws InterruptedException {
        WebElement delPlaylist = driver.findElement(By.xpath("//nav[@class='menu playlist-item-menu']//*[contains(text(),'Delete')]"));
        delPlaylist.click();
        Thread.sleep(5000);





        }

    }

