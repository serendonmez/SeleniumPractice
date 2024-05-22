package Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ {
    public static void main(String[] args) {
        /*
        1- http://babayigit.net/test/ adresine gidilir ve pencere maximize edilir
        2- INFO FORM butonuna tıklanır
        3- Form verileri girilir
        4- Save butonuna tıklanır
        5- Sonuç yazdırılır
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://babayigit.net/test/");
        driver.findElement(By.xpath("//*[@*='img/info.png']"))
                .click();










    }
}
