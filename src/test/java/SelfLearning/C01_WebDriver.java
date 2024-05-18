package SelfLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebDriver {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
        1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/





         */
        driver.get("https://testotomasyonu.com/");
        // 2. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());


        //  3. Sayfa basliginin “Test” icerdigini test edin
        String expectedTitleIcerigi="Test";
        String actualTitle=driver.getTitle();
        Thread.sleep(3000);

        if (actualTitle.contains(expectedTitleIcerigi)){
            System.out.println(" test passed");
        }else {
            System.out.println(" test failed");
        }

        //4. Sayfa adresini(url) yazdirin


        System.out.println(driver.getCurrentUrl());


        // 5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.


        String expectedURL = "https://testotomasyonu.com/";
        String actualURL= driver.getCurrentUrl();

        if (actualURL.equals(expectedURL)){
            System.out.println("test Passed");
        }else {
            System.out.println(" test failed");
        }




        // 6. Sayfa handle degerini yazdirin



        driver.getWindowHandle(); // 234567890
        driver.getWindowHandles(); // [234567890]


        //7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin

        String expectedHTMLCod= "otomasyon";
        String actualHTMLCOd= driver.getPageSource();
        Thread.sleep(3000);

        if (actualHTMLCOd.contains(expectedHTMLCod)){

            System.out.println("passed");
        }else {
            System.out.println("failed");
        }



        Thread.sleep(3000);


        // 8. Sayfayi kapatin.  html kodunda gecmesi page source ?

        driver.quit();


    }
}
