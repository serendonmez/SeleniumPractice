package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.chrono.ThaiBuddhistEra;
import java.util.List;

public class C02_AramaTest {

    // 3 farkli test methodu olustur
    // her method ta asagidaki testleri calistir

    // 1 . methodta Testotomasyonu anasf ya git anasayfaya gittigini test et
    // 2. phone icin arama yap, sonucta ürün bulunabildigini tets et
    // 3. ilk ürüne tikla ürün isminde phone gectigini  (non case sensitive)test et

    static WebDriver driver;
    static List<WebElement> bulunanUrunler;


    @Test
    void toTesti(){


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/");

        String expectedUrl= "https://testotomasyonu.com/";
        String actualUrl= driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }



    }

    @Test
    public void phoneSearch() throws InterruptedException {


        driver.getCurrentUrl();

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        List<WebElement> bulunanUrunler = driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));

     if (!bulunanUrunler.isEmpty()){
         System.out.println("passed");
     }else {
         System.out.println("failed");
     }


     Thread.sleep(3000);





    }

    @Test
    void phoneClick() throws InterruptedException {

        bulunanUrunler.get(0).click();


        //APPLEL iPhone 13 (Starlight, 128 GB)


        WebElement PhoneName= driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedPhoneNAme= "PHONE";
        String actualPHoneNAme= PhoneName
                .getText()
                .toUpperCase();


        if (actualPHoneNAme.contains(expectedPhoneNAme)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
