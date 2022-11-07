package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongHmw18 extends MyBaseTest {
    //we now extend to our own base test named MyBaseTest

    @Test
    public void playASong(){
        //login
//        provideEmail();
//        providePassword("te$t$tudent"); we can remove this and just call the login method
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
    }

//    private void clickOnASong() {
//        WebElement clickOnASong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
//        clickOnASong.click();
//    }

    private void clickAllSongs() {
        // add webdriver wait
        WebElement allSongs = driver.findElement(By.xpath("//a[@class='songs active']"));
        allSongs.click();

//        WebElement allSongs = driver.findElement(By.xpath("//a[@class='songs active']"));
//        allSongs.click();
//
//        WebElement allSongPage = driver.findElement(By.xpath("//h1[normalize-space()='All Songs']"));
//        Assert.assertTrue(driver.findElement((By) allSongPage).isDisplayed());
//
//        WebElement clickOnASong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
//        clickOnASong.click();
//
//        WebElement clickPlay = driver.findElement(By.xpath("//*[@title=\"Play or resume\"]"));
//        clickPlay.click();
//        Assert.assertTrue(driver.findElement((By) clickPlay).isEnabled());
    }
}
