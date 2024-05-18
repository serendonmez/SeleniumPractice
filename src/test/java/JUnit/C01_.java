package JUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ {


        // uni test --> developerlarin yaptigi white box test. (Birim test)

    // J unit testleri bagimsiz calistirabilir
    // bir class ta birden fazla test methodu olunca; test calisma sirasini kendisi belirler.
    // method isimleri test01, test02, test03 gibi yazilirsa o siraya uyar


    @Test
        public void toTesti() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/");

        String expectedUrl= "https://testotomasyonu.com/";
        String actualUrl= driver.getCurrentUrl();
        if (actualUrl.equalsIgnoreCase(expectedUrl)){
            System.out.println(" passed");
        }else {
            System.out.println("failed");
        }

        Thread.sleep(2000);
        driver.quit();

        }

        @Test

        void wiseTesti() throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://wisequarter.com/");

            String expectedUrl= "https://wisequarter.com/";
            String actualUrl= driver.getCurrentUrl();
            if (actualUrl.equalsIgnoreCase(expectedUrl)){
                System.out.println(" passed");
            }else {
                System.out.println("failed");
            }

            Thread.sleep(2000);
            driver.quit();


        }


        @Test
        void youtubeTest() throws InterruptedException {


            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.youtube.com/");

            String expectedUrl= "https://www.youtube.com/";
            String actualUrl= driver.getCurrentUrl();
            if (actualUrl.equalsIgnoreCase(expectedUrl)){
                System.out.println(" passed");
            }else {
                System.out.println("failed");
            }

            Thread.sleep(2000);
            driver.quit();
        }

}
