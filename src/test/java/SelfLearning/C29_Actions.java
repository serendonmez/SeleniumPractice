package SelfLearning;

import Utilities.TestBaseAll;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C29_Actions extends TestBaseAll {


     /*
        1- https://www.testotomasyonu.com/ adresine gidin
2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
3- “Boys” linkine basin
4- Acilan sayfadaki ilk urunu tiklayin
4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
         */

    @Test
    public void text(){

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions= new Actions(driver);

        WebElement kidswear= driver
                .findElement(By.xpath("(//*[@href='https://www.testotomasyonu.com/category/6/products'])[1]"));


        actions.moveToElement(kidswear).perform();
        //3- “Boys” linkine basin

        driver.findElement(By.xpath("//*[text()='Boys']")).click();

        List<WebElement> urunler = driver.findElements(By.xpath("//*[@class='product prod-grid-col4 ']"));


           urunler.get(1).click();


      WebElement BoysText=  driver.findElement(By.xpath("//*[text()='Boys Shirt White Color']"));

      String expectedText="Boys Shirt White Color";

      String actualText= BoysText.getText();
        Assertions.assertEquals(expectedText,actualText);







    }

}
