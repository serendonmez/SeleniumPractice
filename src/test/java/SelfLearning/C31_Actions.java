package SelfLearning;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C31_Actions extends TestBaseAll {



    @Test
    public void test(){


         /*
        1- https://www.testotomasyonu.com/ adresine gidin
2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
3- “Boys” linkine basin
4- Acilan sayfadaki ilk urunu tiklayin
5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
         */



        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin

        Actions actions= new Actions(driver);

        WebElement kidsWear= driver.findElement(By.xpath("(//*[@class='has-sub'])[7]"));

        ReusableMethods.bekle(1);

        actions.moveToElement(kidsWear).perform();

        //3- “Boys” linkine basin
        driver.findElement(By.linkText("Boys"))
                .click();

/*

        //4- Acilan sayfadaki ilk urunu tiklayin
        List<WebElement> urunler =driver.findElements(By.xpath("//*[@class='product-gird ']"));



        ReusableMethods.bekle(1);
        List<String> stringList= new ArrayList<>();

        for (WebElement each: urunler   ) {
           stringList.add(each.getText());
        }
        System.out.println("urun isimleri : " +stringList+" son "); -> urun isimleri : [Boys Boys Shirt White Color $45.00] son


        ReusableMethods.bekle(1);

        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

       String urunIsmi=urunler.getFirst().getText();
        String expectedUrunIsmi= "Boys Shirt White Color";

        System.out.println("urun ismi "+urunIsmi); -> urun ismi Boys Boys Shirt White Color $45.00
        System.out.println("Expected "+expectedUrunIsmi); ->Expected Boys Shirt White Color

        Assertions.assertEquals(expectedUrunIsmi,urunIsmi);

        !!!!!!!!!!!!!!ilk urunun oldugu product gird i list e atip getFirst ile getText alinca
        Webelement üzerindeki tüm yaziyi veriyor ( urun ismi + ücreti)
        istenen Text spesifik locate edilmeli ya da
        !!!!!!!!!!!!!! urunun ilk urunun ("--------") icerdigi test edilebilir
        */

        //4- Acilan sayfadaki ilk urunu tiklayin
         WebElement urunIsmi= driver.findElement(By.xpath("//*[text()='Boys Shirt White Color']"));
        String actualUrunIsmi=urunIsmi.getText();
        String expectedUrunIsmi= "Boys Shirt White Color";
        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);




    }
}
