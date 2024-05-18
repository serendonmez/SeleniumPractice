package Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WebDriverManager {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- testotomasyonu.com anasayfasina gidelim
2- arama kutusunu locate edelim
3- “phone” ile arama yapalim
4- Bulunan sonuc sayisini yazdiralim
5- Ilk urunu tiklayalim
6- Urunun stokta var oldugunu test edin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/");
         WebElement searchBox=  driver.findElement(By.xpath("//input[@id='global-search']"));

         searchBox.sendKeys("phone", Keys.ENTER);

         WebElement sonucSayisi= driver.findElement(By.xpath("//span[text()='4 Products Found']"));

        System.out.println(sonucSayisi.getText());

        WebElement ilkUrun= driver.findElement(By.xpath("(//img[@class='lazy'])[1]"));
        ilkUrun.click();


        WebElement stok= driver.findElement(By.className("add-to-cart"));
        if (stok.isEnabled()) {
            System.out.println("test passed");

        }else {
            System.out.println("test failed");

        }

        Thread.sleep(3000);


        driver.quit();
    }
}
