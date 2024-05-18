package JUnit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C05_BestBuy {

    //  https://www.bestbuy.com/ Adresine gidin
    //  farkli test method’lari olusturarak asagidaki testleri yapin
    //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //	○ logoTest => BestBuy logosunun görüntülendigini test edin
    //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

  static WebDriver  driver;

@BeforeAll
    public static void setup(){

       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.bestbuy.com/");

    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void urlTest(){
        //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl= "https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();

        Assertions.assertEquals(actualUrl, expectedUrl,"sf ayni degil");


    }

    //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    @Test
    public void titleTest(){

    String expectedTitle= "Rest";
    String actualTitle= driver.getTitle();
    Assertions.assertFalse(actualTitle.contains(expectedTitle));



    }

    //	○ logoTest => BestBuy logosunun görüntülendigini test edin

    @Test
    public void logoTest(){

        WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assertions.assertTrue(logo.isDisplayed());
    }

    //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    @Test
    public void francaisTest(){


    WebElement francaBut= driver.findElement(By.xpath("(//*[@lang='fr'])[1]"));

    Assertions.assertTrue(francaBut.isEnabled());



    }




}
