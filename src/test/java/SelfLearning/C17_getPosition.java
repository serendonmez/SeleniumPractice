package SelfLearning;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C17_getPosition {

    public static void main(String[] args) throws InterruptedException {

        /*
        1. https://www.testotomasyonu.com/ sayfasina gidin
2. Sayfanin konumunu ve boyutlarini yazdirin
3. Sayfanin konumunu pixel olarak (50,50)’ye getirin
4. Sayfa boyutunu pixel olarak (1000,500)’ye ayarlayin
4. Sayfanin istenen konum ve boyuta geldigini test edin
5. Sayfayi kapatin.
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.testotomasyonu.com/");


        driver.manage().window().setPosition(new Point(50,50));
        Thread.sleep(3000);

        // Point expectedPosition= driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(999,499));
        Thread.sleep(3000);

      Point actualLastPosition=  driver.manage().window().getPosition();
        System.out.println(actualLastPosition);
        Dimension actualLastDimension= driver.manage().window().getSize();
        System.out.println(actualLastDimension);


        Point expectedLastPosition=new Point(50,50);
        Thread.sleep(3000);

        Dimension expectedLastDimension= new Dimension(1000,500);

        Assertions.assertEquals(actualLastPosition,expectedLastPosition);
        Assertions.assertEquals(actualLastDimension,expectedLastDimension);




        Thread.sleep(3000);
        driver.quit();




    }
}
