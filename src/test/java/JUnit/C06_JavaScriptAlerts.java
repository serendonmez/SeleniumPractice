package JUnit;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C06_JavaScriptAlerts extends TestBaseAll {

    @Test
    public void test(){


        // J script ile olusturulan alert ler WebElement ile locate edilemez.

/*
1. Test
- https://testotomasyonu.com/javascriptAlert adresine gidin
- 1.alert'e tiklayin
- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
- OK tusuna basip alert'i kapatin

 */

        //- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // 1.alert'e tiklayin

        driver.findElement(By.xpath("(//*[@class='j-button'])[1]"))
                .click();

        // cikan Alert ün J script alert oldugunu locate edemememizden anlariz.

        // driver.switchTo().alert().   getText
                                        //dismiss
                                        //sendKeys
                                        //accept methodlari ile alerti handle edebiliriz.


        String expectedAlertText= "I am a JS Alert";

        String actualAlertText= driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertText,actualAlertText);





    }


    @Test
    public void test2(){


        /*

- https://testotomasyonu.com/javascriptAlert adresine gidin
- 2.alert'e tiklayalim
- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
         */

        driver.get("https://testotomasyonu.com/javascriptAlert");
        driver.findElement(By.xpath("(//button[@class='j-button'])[2]"))
                .click();

       // - Cancel'a basip,
        driver.switchTo().alert().dismiss();
        //cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

       String actualCancel= driver.findElement(By.id("result")).getText();
       String expectedCancel= "You clicked: Cancel";

       Assertions.assertEquals(actualCancel,expectedCancel);




    }


    @Test
    public void test3(){

        /*
        3.Test
- https://testotomasyonu.com/javascriptAlert adresine gidin
- 3.alert'e tiklayalim
- Cikan prompt ekranina "Selenyum" yazdiralim
- OK tusuna basarak alert'i kapatalim
- Cikan sonuc yazisinin Selenyum icerdigini test edelim
         */


        //https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("(//*[@class='j-button'])[3]"))
                .click();
        // Cikan prompt ekranina "Selenyum" yazdiralim

        driver.switchTo().alert().sendKeys("Selenyum");

        ReusableMethods.bekle(3);
        // OK tusuna basarak alert'i kapatalim
         driver.switchTo().alert().accept();

       String actualResult=  driver.findElement(By.id("result")).getText();
       String expectedResult="Selenyum";
       Assertions.assertTrue(actualResult.contains(expectedResult));





    }

}
