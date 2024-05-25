package JUnit;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.security.Key;

public class C14_FakerClass extends TestBaseAll {




    @Test
    public void test(){
         /*
        1- https://html.com/tags/iframe/ sayfasina gidelim
2- video’yu gorecek kadar asagi inin
3- videoyu izlemek icin Play tusuna basin
4- videoyu calistirdiginizi test edin
         */


        driver.get("https://html.com/tags/iframe/");
        //2- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                        .sendKeys(Keys.PAGE_DOWN)
                        .perform();
        //3- videoyu izlemek icin Play tusuna basin


        WebElement iframe= driver.findElement(By.xpath("//*[@frameborder='0']"));
        ReusableMethods.bekle(1);
        driver.switchTo().frame(iframe);
        WebElement playButton= driver.findElement(By.xpath("//*[@aria-label='Abspielen']"));
        ReusableMethods.bekle(1);
        playButton.click();


        //4- videoyu calistirdiginizi test edin

        WebElement pause= driver.findElement(By.xpath("//*[@data-title-no-tooltip='Pause']"));



        Assertions.assertTrue(pause.isDisplayed());

        ReusableMethods.bekle(1);










    }
}
