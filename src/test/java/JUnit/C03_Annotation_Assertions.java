package JUnit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C03_Annotation_Assertions {



    // @@Disabled --> görmezden gel

    // test Testleri tek tek calistirir


    // 1- https://www.testotomasyonu.com/ anasayfaya gidin ve anasayfaya gittiginizi test edin
    // 2- phone icin arama yaptirip, arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin


    // eger methodlari birbirine bagli seilde calistiracaksak ; setup methodunu beforeALL seklinde olustur
    // ve teardown i da AfterAll seklinde olusturulur

    static WebDriver driver;

    static List<WebElement> bulunanUrunler;

    @BeforeAll
    public static void setup(){

      driver =  new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterAll
    public static void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    // 1- testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin

    @Test @Order(1)
    public void toTesti() throws InterruptedException {
        driver.get("https://www.testotomasyonu.com/");

        String expectedTestSf= "testotomasyonu";
        String actualTestSf = driver.getCurrentUrl();

        Assertions.assertTrue(actualTestSf.contains(expectedTestSf),"test otomasyon sf degil");
        Thread.sleep(3000);
    }

    @Test @Order(2)
    public void phoneArat() throws InterruptedException {
        // 2- phone icin arama yaptirip, arama sonucunda urun bulunabildigini test edin

        WebElement searchBox= driver.findElement(By.xpath("//input[@type='search']"));
      searchBox.sendKeys("phone"+ Keys.ENTER);

        bulunanUrunler= driver.findElements(By.className("prod-img"));

        Assertions.assertFalse(bulunanUrunler.isEmpty(),"ürün bulunamadi");

        Thread.sleep(3000);

    }

    // 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin

    @Test @Order(3)
    public void firstProduct() throws InterruptedException {

       WebElement phone=  driver.findElement
       (By.xpath("//img[@data-original='https://www.testotomasyonu.com/uploads/product/16882636093576506_65968-removebg-preview.png']"));
       phone.click();
       WebElement productNAme= driver.findElement(By.xpath("//*[@*=' heading-sm mb-4']"));

        String expectedproductName= "phone";
        String actualProductName = productNAme.getText()
                .toLowerCase();

        Assertions.assertTrue(actualProductName.contains(expectedproductName));


        Thread.sleep(3000);


    }



}
