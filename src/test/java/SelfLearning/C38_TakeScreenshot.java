package SelfLearning;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.Exceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C38_TakeScreenshot  extends TestBaseAll {

    @Test
    public void test() throws InterruptedException {



        // test otomasyon sf ina git


        driver.get("https://testotomasyonu.com/");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        // whatsapp numarasina click yapilamadigini test et



        WebElement whatsapp= driver.findElement(By.xpath("//*[@class='fa fa-whatsapp']"));



        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});",whatsapp);

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(whatsapp));

/*
        try {
            whatsapp.click();
            Assertions.assertTrue(true,"Successfully");
        } catch (Exception e) {
            Assertions.fail("not clickable");
        }


*/

       Assertions.assertFalse(whatsapp.isSelected());
        ReusableMethods.saveScreenshotWithDate(whatsapp);


        /*
        try {
            whatsapp.click();
            Assertions.assertTrue(true,"Successfully clicked the Whatsapp number element");
        } catch (Exception e) {
            Assertions.fail("Could not click the Whatsapp number element");
        }
*/

        // web elememtin screenshotini date ile kaydedilcek  screen shot methodu yap




    }






}
