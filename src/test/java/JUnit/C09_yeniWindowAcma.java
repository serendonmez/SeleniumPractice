package JUnit;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

public class C09_yeniWindowAcma extends TestBaseAll {

    @Test
    public void test(){




        driver.get("https://testotomasyonu.com/");
        String testWindowHandle= driver.getWindowHandle();
        System.out.println("test Handle"+testWindowHandle);

        // tab acmak ya da yeni window a
        // gitmek icin switchTo .newWindows kullanilir
        driver.switchTo().newWindow(WindowType.TAB)
                .get("https://www.youtube.com/");
        String yotubeWindowHandle= driver.getWindowHandle();
        System.out.println("youtube window handle"+yotubeWindowHandle);


        ReusableMethods.bekle(5);


        driver.switchTo().newWindow(WindowType.WINDOW)
                .get("https://www.bestbuy.com/");
        String bestWindowHandle= driver.getWindowHandle();
        System.out.println("best window handle "+bestWindowHandle);
        ReusableMethods.bekle(3);


        // tekrar youtube a dönmek icin
        // handle degerine ihtiyacimiz var
        // bu durumda get ve click ten sonra gidilen
        // her window da getWindowHanlde alinmali

        System.out.println(driver.getWindowHandle());
       // driver.getWindowHandles() -->set döndürür
        // set te siralama yoktur bu yüzden kaydetmeden
        // setteki handleNum hangi windowunn Handle degeri
        // oldugunu bilemeyiz
        // handle degerini bildigimiz sf ya geri dönmek icin ;
        driver.switchTo().window(yotubeWindowHandle);
        ReusableMethods.bekle(3);

        // testotomasyonu sf na dönmek icin;
        driver.switchTo().window(testWindowHandle);
        ReusableMethods.bekle(3);

        // title in "Test Otomasyonu" old test et

        String expectedTitle= driver.getTitle();

        // newWindow ile yeni tab ya da window actigimizda
        // handle i String bir degere kaydedersek
        // o window a geri dönebiliriz.



    }




}
