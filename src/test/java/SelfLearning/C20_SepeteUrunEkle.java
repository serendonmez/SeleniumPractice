package SelfLearning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C20_SepeteUrunEkle {
    /*
    1. “https://www.saucedemo.com” Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin
     */
    @Test
    public void test() throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver","src/main/KurulumDosyalari/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.xpath("//*[@data-test='username']"))
                .sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']"))
                .sendKeys("secret_sauce");

        driver.findElement(By.xpath("//*[@data-test='login-button']"))
                .click();


        Thread.sleep(5000);

        WebElement ilkUrun= driver
                .findElement(By.xpath("(//*[@data-test='inventory-item-name'])[1]"));

        ilkUrun.click();


        driver.findElement(By.xpath("//*[@data-test='add-to-cart']"))
                .click();

        driver.findElement(By.xpath("//*[@class='shopping_cart_link']"))
                .click();

      WebElement sepet= driver.findElement
              (By.xpath("//*[@class='inventory_item_name']"));


       String sectigimUrun=ilkUrun.getText(); // expected
        String sonU= sepet.getText();

        Assertions.assertTrue(sonU.contains(sectigimUrun));


        Thread.sleep(3000);

        driver.quit();


    }

}
