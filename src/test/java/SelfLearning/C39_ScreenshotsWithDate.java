package SelfLearning;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C39_ScreenshotsWithDate extends TestBaseAll {

    @Test

    public void screenshot(){



        driver.get("https://testotomasyonu.com/");
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);

      ReusableMethods.saveScreenshotWithDate(aramaSonucElementi);









    }






}
