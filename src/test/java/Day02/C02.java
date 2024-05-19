package Day02;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class C02 {
    public static void main(String[] args) {
        /*
     1-Driver oluşturalim
     2-Java class'imiza chnomedriver.exe i tanitalim
     3-Driver'in tum ekranı kaplamasini saglayalim
     4-"https://www.testotomasyonu.com" adresine gidelim
     5-Driverla sayfanın yuklenmesini 10.000 milisaniye boyunca beklesini
       söyleyelim. Eger oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
     6-Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
     7-Title'ın AŞK ve url inin babayigit kelimesinin içerip icermedigini kontrol edelim
     8-Ardindan "https://wisequarter.com/" adresine gidip
     9-Bu adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
     10-Bir onceki web sayfamiza geri donelim
     11-Sayfayı yenileyelim
     12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
     13- En son adim olarak butun sayfalarimizi kapatmis olalim
    */



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

       String url= driver.getCurrentUrl();
       String baslik= driver.getTitle();

        Assertions.assertEquals(baslik,"AŞK");





    }


}
