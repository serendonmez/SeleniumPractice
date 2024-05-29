package JUnit;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C12_ActionsClass extends TestBaseAll {

    @Test
    public void test(){



         /*
        1- https://testotomasyonu.com/click sitesine gidin
2- “DGI Drones” uzerinde sag click yapin
3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
4- Tamam diyerek alert’i kapatalim
         */

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");



        ReusableMethods.bekle(1);
       // 2- “DGI Drones” uzerinde sag click yapin
           // 1. mouse a islem yaptirmak icin  actions class a ihtiyacimiz var;
            Actions actions=new Actions(driver);

           // 2. üzerinde sag click yapacagimiz elementi locate ederiz:
        WebElement DGI= driver.findElement(By.id("pic2_thumb"));
            //3.  actions obj ile yapacagimiz islemi seceriz:
        ReusableMethods.bekle(1);
            actions.contextClick(DGI).perform();
        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
          String alertText= driver.switchTo().alert().getText();
          String expectedText="Tebrikler!... Sağ click yaptınız.";
        Assertions.assertEquals(expectedText,alertText);

        //4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();


    }
}
