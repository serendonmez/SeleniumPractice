package SelfLearning;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C32_Actions extends TestBaseAll {

    @Test
    public void test(){

        /*
1- https://www.testotomasyonu.com sayfasina gidelim
2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
     */

        driver.get("https://www.testotomasyonu.com");

        Actions actions = new Actions(driver);


        WebElement searchBox= driver.findElement(By.id("global-search"));

        ReusableMethods.bekle(1);
        actions.click(searchBox).keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER).perform();

        ReusableMethods.bekle(1);




        WebElement dellPC=driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']"));
        ReusableMethods.bekle(2);

        String expectedIsim="DELL Core I3";
        String actualIsim= dellPC.getText();

        Assertions.assertTrue(actualIsim.contains(expectedIsim));






    }
}
