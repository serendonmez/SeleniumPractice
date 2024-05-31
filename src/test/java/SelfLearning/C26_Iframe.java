package SelfLearning;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C26_Iframe extends TestBaseAll {





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



        driver.get("https://testotomasyonu.com/discount");

        WebElement iframe= driver.findElement
                (By.xpath("//*[@src='https://testotomasyonu.com/disproduct']"));
        driver.switchTo().frame(iframe);

        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        WebElement elecrtonicsProducts= driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        System.out.println(elecrtonicsProducts.getText());
        Assertions.assertTrue(elecrtonicsProducts.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        ReusableMethods.bekle(5);

        WebElement dellPCimg= driver.findElement


                (By.xpath("//*[@*='http://testotomasyonu.com/uploads/product/1688271616laptop-wooden-table-removebg-preview.png']"));

        System.out.println(dellPCimg.getText());

        ReusableMethods.bekle(2);
        WebElement dellPC= driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"));
        //*[text()='DELL Core I3 11th Gen ']


        String actualPcName=dellPC.getText();
        String expectedPCName="DELL Core I3 11th Gen";

        Assertions.assertEquals(expectedPCName,actualPcName);

        ReusableMethods.bekle(3);

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun
        //olduğunu test edin

        //ilk Iframe den cikis

        driver.switchTo().parentFrame();
        ReusableMethods.bekle(2);

        // 2. iframe gecis

        WebElement sonrakiIframe = driver.findElement(By.xpath("//*[@src='https://testotomasyonu.com/disproduct2']"));

        driver.switchTo().frame(sonrakiIframe);


        ReusableMethods.bekle(3);

       List<WebElement> urunIsimleri= driver.findElements(By.xpath("//ul/li/a//p"));

       boolean menSlimFitVarMi= false;

       for ( WebElement each :urunIsimleri   ) {

           if (each.getText().contains("Men Slim Fit")) {
               menSlimFitVarMi = true;
           }

       }
       Assertions.assertTrue(menSlimFitVarMi);


















    }
}
