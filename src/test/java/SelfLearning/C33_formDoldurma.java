package SelfLearning;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C33_formDoldurma extends TestBaseAll {


    @Test
    public void test(){
        /*
        1- https://www.testotomasyonu.com adresine gidelim
        2- Account linkine tiklayin
        3- Sign Up linkine basalim
        4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        5- Kaydin olusturuldugunu test edin
         */


        driver.get("https://www.testotomasyonu.com");

        // 2- Account linkine tiklayin
        Actions actions=new Actions(driver);

        WebElement account= driver.findElement(By.xpath("(//*[@class='cart-bar'])[1]"));
        ReusableMethods.bekle(1);
        actions.click(account).perform();


       // 3- Sign Up linkine basalim

        WebElement singUp= driver.findElement(By.xpath("//*[@class='sign-up ']"));
        ReusableMethods.bekle(1);
        actions.click(singUp).perform();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        WebElement firstName= driver.findElement(By.xpath("//*[@id='firstName']"));
        ReusableMethods.bekle(1);
        actions=new Actions(driver);
        actions.click(firstName)
                .sendKeys("Meltem"+ Keys.TAB+
                        "Kalay"+Keys.TAB+
                        "meltem@kalay.com" +Keys.TAB+
                        "abc123"+Keys.TAB+
                        "abc123"+Keys.TAB+Keys.ENTER).perform();
        ReusableMethods.bekle(1);

        //5- Kaydin olusturuldugunu test edin

        actions=new Actions(driver);
        WebElement email= driver.findElement(By.id("email"));
        ReusableMethods.bekle(1);
        actions.click(email).sendKeys("meltem@kalay.com"
                +Keys.TAB+"abc123"+Keys.TAB+Keys.ENTER).perform();

        WebElement logout= driver.findElement(By.xpath("(//span[@class='item'])[6]"));

        System.out.println(logout.getText());


    }
}
