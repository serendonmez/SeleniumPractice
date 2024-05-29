package SelfLearning;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class C27_switchingWindow extends TestBaseAll {

    @Test


    public void test(){

 /*
        1- https://testotomasyonu.com/discount adresine gidin
2- Elektronics Products yazisinin gorunur olduğunu test edin
3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin
6- Sayfayi kapatin
         */

        driver.get("https://testotomasyonu.com/discount");

        String toWHD= driver.getWindowHandle();


        //Elektronics Products yazisinin gorunur olduğunu test edin
        // iframe locate ettik
        WebElement iframe= driver.findElement(By.xpath("(//*[@frameborder='1'])[1]"));

        // iframe e girdik
        driver.switchTo().frame(iframe);

        // text in locate ini aldik
      WebElement electronicsText=  driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assumptions.assumeTrue(electronicsText.isDisplayed());

        //3 Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
       WebElement dellLocate= driver.findElement(By.xpath("//*[@id='pictext1']"));
       String dellIsim=dellLocate.getText();
       String expectedUrunISmi="DELL Core I3 11th Gen";

        Assertions.assertEquals(expectedUrunISmi,dellIsim);


        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.

        dellLocate.click();
        ReusableMethods.bekle(3);
        // dell bilgisayar baska bir window page de acildi.
        // bu durumda switchTo Window ie otomatik acilan window a gecis yapariz.

          Set<String> handles= driver.getWindowHandles();

          for ( String each : handles  ) {
             driver.switchTo().window(each);

             if (driver.getCurrentUrl().equals("https://testotomasyonu.com/product/58")){
                 break;
             }
          }
        ReusableMethods.bekle(3);

        String expectedPCFiyat="$399.00";
       String actualPCFiyat= driver.findElement(By.xpath("//*[@id='priceproduct']")).getText();
        System.out.println("$399.00"+actualPCFiyat);
        Assertions.assertEquals(expectedPCFiyat,actualPCFiyat);
        ReusableMethods.bekle(3);



        //5- Ilk sayfaya donun
        String hedefURL="https://testotomasyonu.com/discount";

        Set<String> handles1= driver.getWindowHandles();
        for (String each : handles1   ) {
           driver.switchTo().window(each);
           if (driver.getCurrentUrl().equals(hedefURL)){
               break;
           }
        }


        ReusableMethods.bekle(3);
        // ve Fashion yazisinin gorunur olduğunu test edin

        driver.switchTo().defaultContent(); // driver anasf ya gecti
        ReusableMethods.bekle(3);

        WebElement ikinciIframe= driver.findElement(By.xpath("(//*[@frameborder='1'])[2]")); //
        driver.switchTo().frame(ikinciIframe);
        ReusableMethods.bekle(1);
        WebElement fashionText= driver.findElement(By.xpath("//*[text()='Fashion']"));

        Assertions.assertTrue(fashionText.isDisplayed());





    }
}
