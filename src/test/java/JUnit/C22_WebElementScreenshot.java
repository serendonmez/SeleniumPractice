package JUnit;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class C22_WebElementScreenshot extends TestBaseAll {


    @Test

    void Test() throws IOException {

        driver.get("https://testotomasyonu.com/");

        WebElement searchBox= driver.findElement(By.id("global-search"));

        System.out.println(searchBox.getText());
// phone icin arama yapin
        searchBox.sendKeys("phone"+ Keys.ENTER);

        WebElement productCount= driver.findElement(By.className("product-count-text"));

// arama sonucunda urun bulunabildigini test edin
        String expectedSonuc= "4 Products Found";
        String actualSonuc= productCount.getText();



        //1. adim Web elementin sc

        productCount= driver.findElement(By.className("product-count-text"));

        // 2. adim Resmi kaydedecegimiz File i olustur

        File dosyaYolu= new File("target/Screenshots/WebElementiSC.png");

        //3 .adim sc i al geciic dosyaya koy
        File geciciDosya= productCount.getScreenshotAs(OutputType.FILE);


        //4 . adim gecici dosyayi asil dosyaya kopyala

        FileUtils.copyFile(geciciDosya,dosyaYolu);


        ReusableMethods.takeWebElementScreenshot("bulunan_urun",productCount);


        Assertions.assertEquals(expectedSonuc,actualSonuc);






    }
}
