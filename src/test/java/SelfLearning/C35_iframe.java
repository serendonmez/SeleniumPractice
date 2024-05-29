package SelfLearning;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class C35_iframe  {

    @Test
    public void test(){


        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();



        //     1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
        //     2) Cookies kabul edin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='faktor-iframe-wrapper']"));



        driver.switchTo().frame(iframe);



        WebElement cookie= driver.findElement(By.xpath("//*[text()='Alle akzeptieren']"));
        wait.until(ExpectedConditions.visibilityOf(cookie));
        cookie.click();
        //     3) sayfadaki iframe sayısını bulunuz.

        // 5. iframeden cikis

        driver.switchTo().defaultContent();


        List<WebElement> iframeSayiListi = driver.findElements(By.tagName("iframe"));

        System.out.println(iframeSayiListi.size());




        //     List<String> stringIframes= new ArrayList<>();



        //      4) ilk iframe'deki (Youtube) play butonuna tıklayınız.



        WebElement ilkIframe = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/RbSlW8jZFe8']"));

        driver.switchTo().frame(ilkIframe);

        WebElement videoButton= driver.findElement(By.xpath("//*[@title='Abspielen']"));
        videoButton.click();


        //      5) ilk iframe'den çıkıp ana sayfaya dönünüz

        driver.switchTo().defaultContent();

        //     6) ikinci iframe'deki (Jmeter Made Easy) linke
        //     (https://www.guru99.com/live-selenium-project.html) tıklayınız


        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();




        WebElement ikinciiframe= driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(ikinciiframe);


         WebElement jMeterLink= driver.findElement(By.xpath("//*[@src='Jmeter720.png']"));
         wait.until(ExpectedConditions.elementToBeClickable(jMeterLink));
        jMeterLink.click();

        //      (https://www.guru99.com/live-selenium-project.html) tıklayınız

        driver.quit();




    }


}
