import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ChangeUserNameProfile  extends BaseTest{
    WebDriver driver;
    String url="https://bbb.testpro.io/";

//  private Object enterEmail;
//    private Object provideEmail;

    @Test(priority = 0)
  public void changeUserNameVerifyTheChangeTest() throws InterruptedException {

            provideEmail();
            providePassword();
            clickSubmitBtn();
            clickAvatarIcon();
//            providenewName();
//           provideCurrentPassword("te$t$tudent");

        WebElement newName = driver.findElement(By.xpath("//*[@name='name']"));
        String expectednewName= randomStr();
        newName.sendKeys(expectednewName);

        WebElement currentPassword=driver.findElement(By.xpath("//*[@name='current_password']"));
        currentPassword.sendKeys("te$t$tudent");

        WebElement save = driver.findElement(By.xpath("//*[@class=\"btn-submit\"]"));
        save.click();

        WebElement userNameActual = driver.findElement(By.xpath("//span[@class='name']"));
        Assert.assertEquals(expectednewName,userNameActual);
    }



public String randomStr(){
     return UUID.randomUUID().toString().replace("-","");
}




//    public void provideCurrentPassword(String te$t$tudent) {
//        WebElement currentPassword=driver.findElement(By.xpath("//*[@name='current_password']"));
//        currentPassword.click();
//        currentPassword.sendKeys("te$t$tudent");
//    }
//
//    public void providenewName() {
//        WebElement newName = driver.findElement(By.xpath("//*[@name='name']"));
//        newName.click();
//        newName.sendKeys(randomStr());
//    }

    public void clickAvatarIcon() {
        WebElement avatarIcon= driver.findElement(By.xpath("//*[@alt='Avatar of student']"));
        avatarIcon.click();
    }

//
//    public void userProfile(){
//        WebElement userProfile = driver.findElement(By.xpath("//*[@data-testid=\"view-profile-link\"]"));
//        userProfile.click();
//
// }
//
//      public void save() {
//          WebElement save = driver.findElement(By.xpath("//*[@class=\"btn-submit\"]"));
//          save.click();
//      }
    }