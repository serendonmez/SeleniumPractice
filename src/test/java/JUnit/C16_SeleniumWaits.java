package JUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C16_SeleniumWaits {
/*
1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
2. Remove butonuna basin.
3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
4. Add buttonuna basin
5. It’s back mesajinin gorundugunu test edin
 */


    @Test

    public void implicitlyWait (){


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        WebElement remove= driver.findElement(By.xpath("(//*[@type='button'])[1]"));
        remove.click();

        WebElement itsGone= driver.findElement(By.id("message"));

        // burada yazi yükleninceye kadar bekleme var

        Assertions.assertTrue(itsGone.isDisplayed());


        WebElement add= driver.findElement(By.xpath("//*[text()='Add']"));
        add.click();

        // its back mesaji da yüklenen kadar bir süre geciyor


        WebElement itsBack= driver.findElement(By.id("message"));

        Assertions.assertTrue(itsBack.isDisplayed());
        driver.quit();
    }

    @Test
    public void explicityWait(){



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        WebElement remove= driver.findElement(By.xpath("(//*[@type='button'])[1]"));
        remove.click();



        // burada yazi yükleninceye kadar bekleme var
        // WebdriverWait e burada hem webelementi bulmasini hemde
        // görünür olmasini bekletiyoruz
        // locate etmeyi ve sonunda cikan yaziyi beklemek icin ikisini birlikte yazariz
        // yani kural 1 ve 3 ü ayni anda uyguladik.


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement itsGone= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

                Assertions.assertTrue(itsGone.isDisplayed());




        // 1.adim : mumkunse bekleyecegimiz webelementi locate edin
        // 2.adim : bir wait objesi olusturun
        // 3.adim : wait objesini kullanarak,
        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        // kural 1 ve 3 birlikte

        // add butonun selected old test et

        WebElement add= driver.findElement(By.xpath("//*[text()='Add']"));
        //WebElement add= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add']")));
        // Assertions.assertTrue(add.isSelected());

        add.click();

        // its back mesaji da yüklenen kadar bir süre geciyor
        // görünürlügünü test ettigimiz element sonrada yüklendigi icin gelme süresini
        // driver a explizit olarak bekletmek zorundayiz.
        //
        WebElement itsBack=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assertions.assertTrue(itsBack.isDisplayed());
        driver.quit();








    }




}
