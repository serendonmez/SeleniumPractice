package SelfLearning;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class C36_iframeSorusu extends TestBaseAll {

    @Test
    public void Test01() {


        //     1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        //     2) Cookies kabul edin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='faktor-iframe-wrapper']"));



        driver.switchTo().frame(iframe);



        WebElement cookie= driver.findElement(By.xpath("//*[text()='Alle akzeptieren']"));
        wait.until(ExpectedConditions.visibilityOf(cookie));
        cookie.click();

    WebElement cookiesIFrame = driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(cookiesIFrame);
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//*[text()='Accept All']")).click();
        ReusableMethods.bekle(1);
    List<WebElement> ToplamSayi = driver.findElements(By.tagName("iframe"));
        System.out.println(ToplamSayi.size());
    //   4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    WebElement IframeIlk = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(IframeIlk);
        driver.findElement(By.xpath("//*[@id='movie_player']")).click();
        ReusableMethods.bekle(1);

        //  5) ilk iframe'den çıkıp ana sayfaya dönünüz.
        driver.switchTo().defaultContent();
        ReusableMethods.bekle(2);
    //     6) ikinci iframe'deki (Jmeter Made Easy) linke
    //      (https://www.guru99.com/live-selenium-project.html) tıklayınız.
    // once iframe'e kadar asagi inip
    // o iframe'i locate edelim
    Actions actions= new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
            .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
    WebElement jmeterIFrame= driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(jmeterIFrame);
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']"))
                .click();
        ReusableMethods.bekle(4);

    }

    @Test

    void test() throws InterruptedException {
        ReusableMethods.istenenIframeGec(driver,2,"https://www.guru99.com/live-selenium-project.html");



    }

}
