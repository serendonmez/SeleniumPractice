package GrupCalismasi;

import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02 extends TestBaseAll {
    @Test


    public void test(){


        /*
        1. “https://www.saucedemo.xn--com-9o0a Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin
         */

        driver.get("https://www.saucedemo.com/");


       WebElement userName= driver.findElement(By.xpath("//*[@placeholder='Username']"));
              userName.clear();
                userName.sendKeys("standard_user");
                WebElement surname= driver.findElement(By.xpath("//*[@placeholder='Password']"));
                surname.clear();
                surname.sendKeys("secret_sauce");
                //4. Login tusuna basin
                driver.findElement(By.xpath("//*[@data-test='login-button']")).click();
                //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
               WebElement sectigimUrun= driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));

               String expected = sectigimUrun.getText();
               sectigimUrun.click();

               //6. Add to Cart butonuna basin

        driver.findElement(By.xpath("//*[@data-test='add-to-cart']")).click();

        //7. Alisveris sepetine tiklayin
            driver.findElement(By.xpath("//*[@data-test='shopping-cart-link']")).click();


            //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
            WebElement sepettekiUrun= driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));


          String actual=  sepettekiUrun.getText();

            Assertions.assertEquals(expected,actual);




    }

}
