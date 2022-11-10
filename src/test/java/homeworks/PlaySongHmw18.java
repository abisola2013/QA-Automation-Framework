package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongHmw18 extends MyBaseTest {
    //we now extend to our own base test named MyBaseTest

    @Test
    public void playASong() throws InterruptedException {

        login();//now lets to run it
        clickSubmitBtn();
        clickAllSongs();
        allSongPage();
        String getSongTitle= getSongTitleText();
        playANewSong();

    }


    private void playANewSong() {

//        clickOnASong();
        clickPlay();
        String verifySongPlays= getVerifySongPlays();
         Assert.assertEquals(verifySongPlays,getSongTitleText());


    }

    private String getVerifySongPlays() {
        WebElement verifySong= driver.findElement(By.xpath("//section[@id='songsWrapper']//tr[@class='song-item selected']//td[@class='title']"));
        return verifySong.getText();
    }

    private String getSongTitleText() {
        WebElement getTitleText=driver.findElement(By.xpath("//section[@id='songsWrapper']//tr[@class='song-item selected']//td[@class='title']"));
        return getTitleText.getText();

    }

    private void allSongPage() {
        WebElement allSongPage = driver.findElement(By.xpath("//h1[normalize-space()='All Songs']"));
        Assert.assertTrue(driver.findElement((By) allSongPage).isDisplayed());
    }

    private void clickPlay() {
        WebElement clickPlay = driver.findElement(By.xpath("//*[@title='Play or resume']"));
        clickPlay.click();
        Assert.assertTrue(driver.findElement((By) clickPlay).isEnabled());

        WebElement Visualizer = driver .findElement(By.xpath("//button[@data-testid='toggle-visualizer-btn']//img[@alt='Sound bars']"));
        Assert.assertTrue(Visualizer.isDisplayed());
    }





    private void clickAllSongs() throws InterruptedException {
        // add webdriver wait
        WebElement allSongs = driver.findElement(By.xpath("//a[@class='songs active']"));
        allSongs.click();
       Thread.sleep(2000);



//        The visualizer will be the assertion that the music is playing
    }
}
