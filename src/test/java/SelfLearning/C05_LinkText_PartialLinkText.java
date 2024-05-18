package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_LinkText_PartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- Bir test class’i olusturun ilgili ayarlari yapin
2- https://www.automationexercise.com/ adresine gidin
4- Products linkine tiklayin
5- special offer yazisinin gorundugunu test edin
6- Sayfayi kapatin
         */


        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.automationexercise.com/");




       // WebElement productLinkElement=   driver.findElement(By.linkText(" Products"));
        //--->// bosluktan dolayi yazdirmadi noSuchElementException verdi
        // bu nedenle boslugu silip  patialLink i denedik


        WebElement productLinkElement=   driver.findElement(By.partialLinkText("Products"));

        productLinkElement.click();


        WebElement productIMG=  driver.findElement(By.className("sale_image"));
        if (productIMG.isDisplayed()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
