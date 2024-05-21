package SelfLearning;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C25_IframeSoru extends TestBaseEach {

    /*
    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
2) Cookies kabul edin
3) sayfadaki iframe sayısını bulunuz.
4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
5) ilk iframe'den çıkıp ana sayfaya dönünüz
6) ikinci iframe'deki (Jmeter Made Easy) linke
(https://www.guru99.com/live-selenium-project.html) tıklayınız
     */
    @Test
    public  void test() {

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) Cookies kabul edin


      /* driver.findElement(By.xpath("//*[@id='save']"))
                .click(); */




        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        WebElement iframe= driver.findElement(By.xpath("//*[@wmode='transparent']"));

        driver.switchTo().frame(iframe);

        WebElement youtubeButton= driver.findElement(By.xpath("//button[@aria-label='Abspielen']"));
                youtubeButton.click();
        //5) ilk iframe'den çıkıp ana sayfaya dönünüz

        driver.switchTo().defaultContent();

        //6) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız

        WebElement ikinciIframe = driver.findElement(By.xpath("//*[@name='a077aa5e']"));

        driver.switchTo().frame(ikinciIframe);

        WebElement link = driver.findElement
                (By.xpath("//*[@href='http://www.guru99.com/live-selenium-project.html']"));

        link.click();

        Assertions.assertTrue(link.isEnabled());


        ReusableMethods.bekle(3);






    }
}
