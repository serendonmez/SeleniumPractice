package JUnit;

import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C08_IFrame extends TestBaseEach {



    @Test
    public void test(){

        /*
        1- https://testotomasyonu.com/discount adresine gidin
2- Elektronics Products yazisinin gorunur olduğunu test edin
3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun
olduğunu test edin
5- ‘Fashion’ yazisinin gorunur olduğunu test edin
6- ‘Here are some products’ yazisinin gorunur olduğunu test edin
7- Sayfayi kapatin
         */


        //Iframeler genellikle videolari, haritalari bir web sf ina gömmek icin kullanilir.
        // embedded software,
        // <iframe> tagi icinde header ve body bulunur
        // <iframe> tagi olan web sf i 1 den fazla html tagi icerir

        // iframe tagi icindeki webElementi locate etmek icin;
        // driver.switchTo().frame(iframeElementi);

        // 1- https://testotomasyonu.com/discount adresine gidin

        driver.get("https://testotomasyonu.com/discount");
//2- Elektronics Products yazisinin gorunur olduğunu test edin
        // öncelikle aradigimiz webElementiin icinde oldugu Iframei locate ederiz.


      WebElement iframe= driver.findElement(By.xpath("(//iframe)[1]"));
      //iframe gecis yapilir
      driver.switchTo().frame(iframe);

      // artik aradigimiz webElementi locate edebiliriz.

        WebElement electronicsText= driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsText.isDisplayed());










    }
}
