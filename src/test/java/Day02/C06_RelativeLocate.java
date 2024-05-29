package Day02;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class C06_RelativeLocate extends TestBaseAll {



    @Test
    public void test(){

        driver.get("https://testotomasyonu.com/relativeLocators");
      WebElement yardimciElement= driver.findElement(By.id("pic4_thumb"));

       WebElement aranilanElement= driver.findElement(RelativeLocator.with(By.id("pic10_thumb")).near(yardimciElement));

               aranilanElement.click();

        ReusableMethods.bekle(3);

         WebElement text= driver.findElement(By.xpath("(//*[text()='Samsung Smart Watch Black'])[1]"));

         String actualText= text.getText();
         String expectedText="Samsung Smart Watch Black" ;



        Assertions.assertEquals(expectedText,actualText,"erisilemedi");

    }
}
