package JUnit;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C07_Authentication extends TestBaseEach {

    // username ve password ile girilebilen URL lerde
    // Web sf sinin user a bu bilgileri vermis olmasi gerekir
    // End user’lar icin tasarlanmayan uygulamalarda (Ornegin API sorgularinda) bu
    //authentication HTML komutlari ile yapilabilir
    // Html komutu : https://username:password@URL gibi


    @Test

    public void authentication(){
/*
1- Bir class olusturun : BasicAuthentication
2- https://testotomasyonu.com/basicauth sayfasina gidin
3- asagidaki yontem ve test datalarini kullanarak
authentication’i yapin
Html komutu : https://username:password@URL
Username : membername
password : sunflower
4- Basarili sekilde sayfaya girildigini dogrulayin
https://membername:sunflower@testotomasyonu.com/basicauth
 */


        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        ReusableMethods.bekle(5);

      String actualText=  driver.findElement
              (By.xpath("//*[text()='Congratulations! You are logged in as: membername']")).getText();

        System.out.println(actualText);


        // element görünür mü
        WebElement actualTextElement = driver.findElement
                (By.xpath("//*[text()='Congratulations! You are logged in as: membername']"));
        Assertions.assertTrue(actualTextElement.isDisplayed());


    }



}
