package SelfLearning;

import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C21_Category_ extends TestBaseAll {

    @Test
    public void Category (){

        //   2- https://www.automationexercise.com/ adresine gidin
        //           3- Category bolumundeki elementleri locate edin
//4- Category bolumunde 3 element oldugunu test edin
//5- Category isimlerini yazdirin
//6- Sayfayi kapatin


        driver.get("https://www.automationexercise.com/");

         List<WebElement> categoryElementleri = driver
                 .findElements(By.xpath("//*[@class='panel panel-default']"));


         for (WebElement each : categoryElementleri   ) {
             System.out.println(each.getText());
         }

        int expectedcategorySayisi= 3;
        System.out.println(expectedcategorySayisi);
        int actualcategorySayisi= categoryElementleri.size();
        System.out.println(actualcategorySayisi);

         Assertions.assertTrue(expectedcategorySayisi==actualcategorySayisi);

                driver.quit();


    }
}
