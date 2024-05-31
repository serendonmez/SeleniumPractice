package JUnit;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class C20Screenshot extends TestBaseAll {



    @Test
    public  void test() throws IOException, InterruptedException {

// testotomasyon anasayfaya gidin
        driver.get("https://testotomasyonu.com/");

        WebElement searchBox= driver.findElement(By.id("global-search"));
// Java icin arama yapin
        searchBox.sendKeys("java"+ Keys.ENTER);

// arama sonucunda urun bulunabildigini test edin


        WebElement productCount= driver.findElement(By.className("product-count-text"));
        String actualProductCount= productCount.getText();
        String unexpectedProductCount= "0 Products Found";




// Screenshot almak icin 4 adim atariz


        // 1. adim TakeScreenshot Objesi olusturmak
        ReusableMethods.bekle(1);
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        // 2. screenshotlari kaydetmek iicn bir directory olusturduk
        //    target/Screenshots  (+ DosyaAdi Yazilmali .png ->Foto

        File tumSayfaScreenshots = new File("target/Screenshots/ekranResmi.png");


        //3 . adim sf Fotosunu cekip bir dosyaya yükleyelim

        File geciciDosya =takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4. adim gecici dosyayi asil dosyaya copy edelim

        FileUtils.copyFile(geciciDosya,tumSayfaScreenshots);


        Assertions.assertNotEquals(unexpectedProductCount,actualProductCount);


    }
}
