package JUnit;

import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C15_SeleniumWaits  {


    @Test
    public void implicitlyWaitTesti(){


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
       WebElement enable= driver.findElement(By.xpath("//*[@type='text']"));
        Assertions.assertFalse(enable.isEnabled());
        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        WebElement enableButton= driver.findElement(By.xpath("(//*[@type='button'])[2]"));

        enableButton.click();

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.


        WebElement enabled= driver.findElement(By.id("message"));
        Assertions.assertTrue(enabled.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        String expectedEnabled= "It's enabled!";
        String actualEnabled=  enabled.getText();
        Assertions.assertEquals(expectedEnabled,actualEnabled);

        driver.quit();

    }





    @Test
    public void explicitlyWaitTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement enable= driver.findElement(By.xpath("//*[@type='text']"));
        Assertions.assertFalse(enable.isEnabled());
        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        WebElement enableButton= driver.findElement(By.xpath("(//*[@type='button'])[2]"));

        enableButton.click();


        // burada explicitly wait ile bekleme yapabiliriz ( Web elementin bulunmasi garanti olsun diye)

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.elementToBeClickable(enableButton));


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.


        WebElement enabled= driver.findElement(By.id("message"));
        Assertions.assertTrue(enabled.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        String expectedEnabled= "It's enabled!";
        String actualEnabled=  enabled.getText();
        Assertions.assertEquals(expectedEnabled,actualEnabled);

        driver.quit();



    }
}
