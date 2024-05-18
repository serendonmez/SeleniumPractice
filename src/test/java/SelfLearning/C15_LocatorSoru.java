package SelfLearning;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C15_LocatorSoru {
    public static void main(String[] args) throws InterruptedException {

        /*
        1- Bir test class’i olusturun ilgili ayarlari yapin
2- http://zero.webappsecurity.com/ adresine gidin
3- “ONLINE BANKING” linkine tiklayin
4- Resim altinda 6 islem basligi oldugunu test edin
5- Islem basliklari icinde “Pay Bills” oldugunu test edin
6- Sayfayi kapatin

         */


      System.setProperty("WebDriver.chrome.driver","src/main/KurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://zero.webappsecurity.com/");
       WebElement onlineBanking= driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBanking
                .click();




        List<WebElement> islemSayisi= driver.findElements(By.className("headers"));

        String paybill= islemSayisi.get(3).getText();
        System.out.println(paybill);


        Assertions.assertEquals(paybill,"Pay Bills","failed");


        Thread.sleep(3000);



        driver.quit();


    }
}
