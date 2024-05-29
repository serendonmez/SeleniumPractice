package JUnit;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class C10_kontrolsuzAcilanYeniWindowaGecis extends TestBaseAll {

    @Test

    public void test(){


/*
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin
 */


        driver.get("https://the-internet.herokuapp.com/windows");
      WebElement textElement= driver.findElement(By.tagName("h3"));
      String internetHandle=driver.getWindowHandle();


      String expectedText="Opening a new window";
      String actualText=textElement.getText();

        Assertions.assertEquals(expectedText,actualText,"textler esit degil");

        String expectedBaslik="The Internet";
        String actualBaslik= driver.getTitle();

        Assertions.assertEquals(expectedBaslik,actualBaslik);

        // Click Here butonuna basın.
        WebElement clickWindow=driver.findElement(By.xpath("//*[text()='Click Here']"));
                clickWindow.click();


        ReusableMethods.bekle(5);

  //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
       // yeni Window otomatik acildigi icin driver i da yeni window a gecirmeliyiz
        // driver i gecirmek icin handle degerine ihtiyacimiz olacak
        // ilk handle degerini internetHandle olarak almistik. 2. degeri almak icin
        // tüm handle lari alip ilkine esit olmayani yeni Windowun Handle degeri olarak
        // String bir degere atayabiliriz.

        Set<String> ikiWindowunHandleDegeri =driver.getWindowHandles();

        String ikinciWindowHandle="";
        for ( String each :ikiWindowunHandleDegeri   ) {
           if (!each.equals(internetHandle)){
               ikinciWindowHandle=each;
           }
        }

        // burada newWindow demiyoruz. var olan (kendi kendine acilan) bir window old icin
        // window () kullaniriz.
        driver.switchTo().window(ikinciWindowHandle);

        //Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement newWindowText= driver.findElement(By.tagName("h3"));

        String expectedTitle="New Window";
        String actualTitle= driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin

               driver.switchTo().window(internetHandle);

               String expectedsfBaslik="The Internet";
               String actualsfBaslik= driver.getTitle();

               Assertions.assertEquals(expectedsfBaslik,actualsfBaslik);


               String yeniInternetHandle= driver.getWindowHandle();

        System.out.println(internetHandle);
        System.out.println(yeniInternetHandle);

        ReusableMethods.windowaGecis("https://www.youtube.com/",driver);

        System.out.println(driver.getCurrentUrl());


        ReusableMethods.bekle(5);

    }
}
