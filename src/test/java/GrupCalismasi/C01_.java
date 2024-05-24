package GrupCalismasi;

import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C01_ extends TestBaseAll {

    /*
    1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password” yazin
5. Sign in tusuna basin, back tusuna basarak sayfaya donun
6. Online banking menusunden Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
kontrol edin
     */

    @Test
    public void test(){
        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.className("icon-signin")).click();
        driver.findElement(By.id("user_login"))
                .sendKeys("username"+Keys.TAB+"password");
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();


        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();


        //Pay Bills sayfasina gidin

        driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();
        driver.findElement(By.xpath("//*[@href='#ui-tabs-3']")).click();
        WebElement ddm= driver.findElement(By.xpath("//*[@id='pc_currency']"));

        Select select = new Select(ddm);
        select.selectByValue("EUR");
        driver.findElement(By.id("pc_amount")).sendKeys("100");

        //“US Dollars” in secilmedigini test edin
             WebElement dollars=   driver.findElement(By.id("pc_inDollars_true"));
        Assertions.assertFalse(dollars.isSelected());

        driver.findElement(By.xpath("(//*[@name='inDollars'])[2]")).click();

        driver.findElement(By.xpath("//input[@type='button']")).click();
        driver.findElement(By.id("purchase_cash"))
                .click();


       WebElement succesText= driver.findElement(By.id("alert_content"));
        String expectedText="Foreign currency cash was successfully purchased.";
       String actualText=succesText.getText();

       Assertions.assertEquals(expectedText,actualText);





    }



}
