package SelfLearning;

import Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C34Cookies extends TestBaseAll {
    @Test
    public void test01(){

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) Cookies kabul edin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // iframe gecis
        WebElement iframe= driver.findElement(By.xpath("//iframe[@class='faktor-iframe-wrapper']"));

        wait.until(ExpectedConditions.visibilityOf(iframe));

        driver.switchTo().frame(iframe);

        WebElement cookie= driver.findElement(By.xpath("//*[text()='Alle akzeptieren']"));
        cookie.click();


        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        //5) ilk iframe'den çıkıp ana sayfaya dönünüz
        //6) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız


    }




}
