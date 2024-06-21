package GrupCalismasi;

import Utilities.TestBaseAll;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class C03_TestCase1 extends TestBaseAll {

    @Test
    public void test() throws InterruptedException {



//1. Launch browser
        driver.get("about:blank");


//2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        // cerezleri onayla
        driver.findElement(By.xpath("//*[text()='Einwilligen']")).click();
//3. Verify that home page is visible successfully
        WebElement homepage=driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assertions.assertTrue(homepage.isDisplayed());
//4. Click on 'Signup / Login' button


        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

//5. Verify 'New User Signup!' is visible
      WebElement newUser=  driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assertions.assertTrue(newUser.isDisplayed());
//6. Enter name and email address
        Faker faker = new Faker();

        Actions actions=new Actions(driver);
       String name= String.valueOf(faker.name().firstName());
       String email=faker.internet().emailAddress();

        WebElement nameKutusu= driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        //7. Click 'Signup' button
        actions.sendKeys(nameKutusu,name).perform();

      WebElement emailKutusu= driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
      actions.sendKeys(emailKutusu,email).keyDown(Keys.TAB).keyDown(Keys.ENTER).perform();

      // dign in //*[@data-qa='signup-button']


//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assertions.assertTrue(enterAccount.isDisplayed());
//9. Fill details: Title, Name, Email, Password, Date of birth
      driver.findElement(By.id("id_gender2")).click();
WebElement nameYaz= driver.findElement(By.xpath("//*[@data-qa='name']"));

       String password= faker.internet().password();
        actions.click(nameYaz).keyDown(Keys.TAB).sendKeys(email).keyDown(Keys.TAB).sendKeys(password).keyDown(Keys.TAB).perform();

        WebElement day= driver.findElement(By.xpath("//*[@data-qa='days']"));

        Select select=new Select(day);

        select.selectByValue("4");

        WebElement ay= driver.findElement(By.xpath("//*[@data-qa='months']"));
        Select select1=new Select(ay);
        select1.selectByIndex(10);

        WebElement yil=driver.findElement(By.xpath("//*[@data-qa='years']"));
        Select select2=new Select(yil);
        select2.selectByVisibleText("1999");

//10. Select checkbox 'Sign up for our newsletter!'

        WebElement forNewsLetter=driver.findElement(By.id("newsletter"));

        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",forNewsLetter);


//11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();
        Thread.sleep(10000);
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName=driver.findElement(By.xpath("//*[@data-qa='first_name']"));
        name= String.valueOf(faker.name().firstName());
       String lastName= faker.name().lastName();
       String company= String.valueOf(faker.company());
       String adress= String.valueOf(faker.address());
       actions.click(firstName).sendKeys(name).keyDown(Keys.TAB).sendKeys(lastName).keyDown(Keys.TAB).sendKeys(company)
               .keyDown(Keys.TAB).sendKeys(adress).perform();


       WebElement country= driver.findElement(By.xpath("//*[@data-qa='country']"));

       Select select3=new Select(country);
       select3.selectByIndex(1);

       Thread.sleep(5000);



       WebElement stateWebelement= driver.findElement(By.xpath("//*[@data-qa='state']"));
        String state= faker.address().state();
       String city= faker.address().cityName();
       String zipCode= faker.address().zipCode();
       String tell= String.valueOf(faker.phoneNumber());
       actions.click(stateWebelement).sendKeys(state).keyDown(Keys.TAB).sendKeys(city).keyDown(Keys.TAB)
               .sendKeys(zipCode).keyDown(Keys.TAB).sendKeys(tell).perform();

       WebElement createAccount=driver.findElement(By.xpath("//*[@data-qa='create-account']"));
        javascriptExecutor.executeScript("arguments[0].click();",createAccount);
      // createAccount.click();

//13. Click 'Create Account button'

//14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated=driver.findElement(By.xpath("//*[text()='Account Created!']"));

        Assertions.assertTrue(accountCreated.isDisplayed());
//15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
//16. Verify that 'Logged in as username' is visible


        WebElement inUserName= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assertions.assertTrue(inUserName.isDisplayed());
//17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        WebElement deleted= driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assertions.assertTrue(deleted.isDisplayed());


    }
}
