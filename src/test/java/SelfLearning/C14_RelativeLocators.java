package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.lang.invoke.StringConcatFactory;
import java.time.Duration;

public class C14_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        // web elementi etrafindaki elementlerle tarif ederek locate  etme

/*
1 ) https://testotomasyonu.com/relativeLocators adresine gidin
2 ) DSLR Camera’yi etrafindaki elementleri kullanarak 3 farkli relative
locator ile locate edip tiklayin
3 ) Acilan urunun DSLR Camera oldugunu test edin.
 */



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/relativeLocators");

        // Kullanmak istedigimiz webElemente ait bir locate bilgisi -->id="pic7_thumb"
        // etrafinda kullanilabilecek bir webElemente ihtiyac olunur -->//*[@id='pic6_thumb']

        WebElement appKualklik = driver.findElement(By.xpath("//*[@id='pic6_thumb']"));

        WebElement dslCamera1= driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toRightOf(appKualklik));

        dslCamera1.click();

         // 3 ) Acilan urunun DSLR Camera oldugunu test edin.
        WebElement DSLRCamText= driver.findElement(By.xpath("(//*[text()='DSLR Camera'])[1]"));


        String expected ="DSLR CAMERA";
        String actual =DSLRCamText.getText();
        if (actual.equalsIgnoreCase(expected)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        // bir sf geri dönüs baska bi webElement ile locate edelim.

        driver.navigate().back();




        // aradigimiz WebElementin bir bilgisine -->
        // komsu Webelementin locatine ihtiyacimiz var --> //img[@id='pic12_thumb']

        WebElement HPVictusPC= driver.findElement(By.xpath("//img[@id='pic12_thumb']"));
        WebElement DSLRCam= driver.findElement(RelativeLocator.with(By.tagName("img")).above(HPVictusPC)  );

          //3 ) Acilan urunun DSLR Camera oldugunu test edin

        DSLRCam.click();

        WebElement DSLRCAMText= driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedText= "DSLR Camera";
        String actualTest= DSLRCAMText.getText();
        if (actualTest.equalsIgnoreCase(expectedText)){
            System.out.println("Passed");
        }else {
            System.out.println("failed");
        }

        // StaleElementReferanceException  eski locate edilmis elemet icin 



        Thread.sleep(4000);

        driver.quit();


    }
}
