package GrupCalismasi;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C06_ extends TestBaseAll {

    @Test
    public void test01() throws IOException {

// test otomasyon sf ina git


// sayfanin en altinda bulunan whatsapp numarasina click yapilamadigini test et
// web elementin screenshotini date ile kaydedilecek  screen shot methodu yap

        driver.get("https://testotomasyonu.com/");

        WebElement whatsapp= driver.findElement(By.xpath("//*[@class='fa fa-whatsapp']"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});",whatsapp);

        ReusableMethods.bekle(1);


        Assertions.assertFalse(whatsapp.isSelected());

       // TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        File dosyaYolu= new File("target/Screenshots/"+"02.06.2024"+".png");

        File geciciDosya= whatsapp.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,dosyaYolu);

    }




}
