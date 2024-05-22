package Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ {
    public static void main(String[] args) {

        /*
1-https://babayigit.net/test/index.html adresine gidin
2-Arama kutusuna wise quarter yazıp saerch butonuna tıklayın
3-Arama sonuçlarında sonuç sayısını kaydedip yazdırın

 */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://babayigit.net/test/index.html");
       WebElement searchBox= driver.findElement(By.id("search"));

       searchBox.sendKeys("wise quarter"+ Keys.ENTER);
       driver.findElement(By.id("hdtb-tls")).click();
      String sonucSayisi= driver.findElement(By.id("result-stats")).getText();
        System.out.println(sonucSayisi);


        driver.quit();


    }
}
