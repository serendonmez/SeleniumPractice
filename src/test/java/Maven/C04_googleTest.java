package Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_googleTest {
    public static void main(String[] args) throws InterruptedException {
        /*

2- https://www.google.com/ adresine gidin
3- cookies uyarisini kabul ederek kapatin
4- Sayfa basliginin “Google” ifadesi icerdigini test edin
5- Arama cubuguna “Nutella” yazip aratin
6- ilk ürünün saga kaydirma fonksiyonu enable mi? test et
7- Sayfayi kapatin
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");

        WebElement cookies = driver.findElement(By.xpath("//button[@*='W0wltc']"));
       cookies.click();

       // sf Basligi


       String expectedTitle= "Google";
       String actualTitle= driver.getTitle();
       if (actualTitle.contains(expectedTitle)){

           System.out.println("passed");
       }else {
           System.out.println("failed");
       }

       // image deki text i okuyabilir mi ?

        WebElement googleTitle = driver.findElement(By.xpath("//img[@class='lnXdpd']"));

        System.out.println(googleTitle.getText()+" resimdeki yaziyi okumyaz");


        WebElement searchBox=  driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchBox.sendKeys("Nutella", Keys.ENTER);


        // ilk ürünün saga kaydirma fonksiyonu enable mi?

        WebElement firstNutella= driver.findElement(
                By.xpath("(//*[@d='M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z'])[2]"));


        if (firstNutella.isEnabled()){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }


        Thread.sleep(3000);
        driver.quit();

    }
}
