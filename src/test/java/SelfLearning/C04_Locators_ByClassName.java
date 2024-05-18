package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Locators_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin

        driver.get("https://testotomasyonu.com/");

        // arama kutusunu locate edip kaydedin
        WebElement searchBox = driver.findElement(By.id("global-search"));





        // dress icin arama yapin

        searchBox.sendKeys("dress" + Keys.ENTER);

        // bulunan urun sayisinin 3'den fazla oldugunu test edin



        WebElement dressCount = driver.findElement(By.className("product-count-text"));

        System.out.println(dressCount.getText());  //10 Products Found

       // get text methodu String döner

        String dressCount1= dressCount.getText();

        dressCount1=dressCount1.replaceAll("\\D","");

        System.out.println(dressCount1); //10


        int dressCountInt= Integer.parseInt(dressCount1);

        if (dressCountInt>3){
            System.out.println("Test passed");
        }else {
            System.out.println("test failed");
        }


        Thread.sleep(4000);







        driver.quit();

    }
}
