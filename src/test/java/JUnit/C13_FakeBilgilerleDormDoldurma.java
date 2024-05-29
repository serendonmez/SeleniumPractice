package JUnit;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C13_FakeBilgilerleDormDoldurma extends TestBaseAll {

    @Test
    public void test(){
        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Account linkine tiklayin

        Actions actions = new Actions(driver);
       WebElement account= driver.findElement(By.xpath("(//a[@class='e-cart'])[1]"));

        ReusableMethods.bekle(1);
       actions.click(account).perform();

        //3- Sign Up linkine basalim

     WebElement signUp=  driver.findElement(By.xpath("//*[@class='sign-up ']"));
     ReusableMethods.bekle(1);
       actions.click(signUp).perform();

        //4- Ad, soyad, mail ve sifre kutularina fake degerler yazalim

        Faker faker= new Faker();
        WebElement firstName = driver.findElement(By.id("firstName"));
        ReusableMethods.bekle(1);

        String email= faker.internet().emailAddress();
        String password = faker.internet().password();

        actions.click(firstName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();




        //5-  ve Sign Up butonuna basalim

        WebElement emailWebElement= driver.findElement(By.id("email"));
        ReusableMethods.bekle(1);
        actions.click(emailWebElement)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //6- Kaydin olusturuldugunu test edin

        WebElement profil = driver.findElement(By.className("profile"));

        Assertions.assertTrue(profil.isDisplayed());




















    }


















}
