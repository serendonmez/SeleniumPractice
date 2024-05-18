package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_WebElementMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get("https://testotomasyonu.com/");

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

       //  aramaKutusu.clear();
      //  System.out.println(aramaKutusu.isEnabled());

         // aramaKutusu.isSelected(); --> webElement checkBox ya da Radio button ise kullanilir
        System.out.println(aramaKutusu.getAttribute("id"));


        Thread.sleep(2000);
         driver.quit();


    }
}
