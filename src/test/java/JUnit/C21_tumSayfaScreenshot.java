package JUnit;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class C21_tumSayfaScreenshot extends TestBaseAll {


    @Test
    void test() throws IOException, InterruptedException {

// testotomasyon anasayfaya gidin
        driver.get("https://testotomasyonu.com/");

        WebElement searchBox= driver.findElement(By.id("global-search"));

        System.out.println(searchBox.getText());
// phone icin arama yapin
        searchBox.sendKeys("phone"+ Keys.ENTER);

        WebElement productCount= driver.findElement(By.className("product-count-text"));

// arama sonucunda urun bulunabildigini test edin
        String expectedSonuc= "4 Products Found";
        String actualSonuc= productCount.getText();



        Thread.sleep(3000);

        ReusableMethods.takeScreenshot(driver, "ilkCekilenScreenshot");
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        File tumSayfaScreenshot= new File("target/Screenshots/ekranResmi.png");

        File geciciDosya= takesScreenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);

        Assertions.assertEquals(expectedSonuc,actualSonuc);


        ReusableMethods.takeScreenshot(driver,"ilk_urun_Resmi");



    }
}
