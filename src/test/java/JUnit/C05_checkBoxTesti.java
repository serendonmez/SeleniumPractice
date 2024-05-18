package JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C05_checkBoxTesti {

    /*
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
 a. Verilen web sayfasına gidin.
     https://testotomasyonu.com/form
 // b. Sirt Agrisi ve Carpinti checkbox’larini secin
  // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
  // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
     */


    static WebDriver driver;

    @BeforeAll
    public static void setup(){


        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/form");


    }

    @AfterAll
    public static void teardown (){

        driver.quit();

    }


    @Test
    public void sirtCarpinti() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)"); // 600 piksel aşağı kaydır

        /*
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();   ya da page Down yapilabilir
         */

        Thread.sleep(3000);


        // b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement carpintiCheckBox= driver.findElement(By.id("gridCheck4"));

        carpintiCheckBox.click();

        WebElement sirt = driver.findElement(By.id("gridCheck5"));
        sirt.click();
        Assertions.assertTrue(carpintiCheckBox.isSelected()&&sirt.isSelected(),"carpinti ve" +
                "sirt boxi secili degil");
        Thread.sleep(3000);

    }

    @Test
    public void sekerEpilepsi() throws InterruptedException {

        // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin


        WebElement seker = driver.findElement(By.xpath("//input[@id='hastalikCheck2']"));

        WebElement epilepsi = driver.findElement(By.xpath("//input[@id='hastalikCheck7']"));

                                                            //   //input[@id='hastalikCheck7']

        Assertions.assertFalse(seker.isSelected()&&epilepsi.isSelected(),"secili degil");

        Thread.sleep(3000);


    }
}
