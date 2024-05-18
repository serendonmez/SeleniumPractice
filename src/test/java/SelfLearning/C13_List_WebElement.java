package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C13_List_WebElement {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- bir class olusturun
2- https://www.testotomasyonu.com/ adresine gidin
3- Browseri tam sayfa yapin
4- Sayfayi “refresh” yapin
5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
6- Furniture linkine tiklayin
7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin
8- filtreleme sonucunda urun bulunabildigini test edin
10-Ilk urunu tiklayin
11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
12-Sayfayi kapatin
         */


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.testotomasyonu.com/");

        driver.navigate().refresh();

        String expectedBaslik = "Test Otomasyonu";
        String actualBaslik= driver.getTitle();
        if (actualBaslik.contains(expectedBaslik)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        // Furniture linkine tiklayin
        //    //a[text()='Furniture'] --> 3 adet bu syntax ta webelement bulundu.
        // 3. bizim aradigimiz old icin  (    //a[text()='Furniture']    )[3] seklinde belirttik

        //(//a[text()='Furniture'])[3]

        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]"))
                .click();
//*[@class='form-control minPrice']

       // 7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        WebElement minDeger = driver.findElement(By.xpath("//*[@class='form-control minPrice']"));
        minDeger.clear();
        minDeger.sendKeys("40"+ Keys.ENTER);


        WebElement maxDeger= driver.findElement(By.xpath("//*[@class='form-control maxPrice']"));
        maxDeger.clear();
        maxDeger.sendKeys("200"+Keys.ENTER);
        // fiyat araligi girildiken sonra fltrele butonu sf nin altinda kalmissa
        // ("200"+Keys.PAGE_DOWN); ile asagi inilir

       // 8- filtreleme sonucunda urun bulunabildigini test edin

        List<WebElement> urunler = driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));
        if (!urunler.isEmpty()){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

         //10-Ilk urunu tiklayin

        // listedeki ilk element icin
        // urunler.get (0).click diye ilk ürünü secebiliriz

        driver.findElement(By.xpath("//a[text()='Product Tax']"))
                .click();

       WebElement urunFiyat= driver.findElement(By.xpath("//span[text()='$50.00']"));
        System.out.println(urunFiyat.getText());
        String fytText= urunFiyat.getText();
        fytText= fytText.replaceAll("\\D","");

       int fytInt= Integer.parseInt(fytText );
        fytInt=fytInt/100;
       System.out.println(fytInt);

       if (fytInt>40 && fytInt<200){
           System.out.println("passed");
       }else {
           System.out.println("failed");
       }


        Thread.sleep(3000);
        driver.quit();

    }
}
