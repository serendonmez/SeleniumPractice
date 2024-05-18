package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
        1- Bir test class’i olusturun ilgili ayarlari yapin
2- https://www.automationexercise.com/ adresine gidin
3- Sayfada 147 adet link bulundugunu test edin.
4- Sayfayi kapatin
         */
        driver.get("https://www.automationexercise.com/");

             List<WebElement>  cookiesAcceptList= driver.findElements(By.className("fc-button-label"));

             cookiesAcceptList.get(0).click();
             Thread.sleep(3000);

        List<WebElement> linkElementleri=  driver.findElements(By.tagName("a"));

         // System.out.println(linkElementleri.size());

        int expectedLinkCount= 147;
        int actualLinkCount= linkElementleri.size();

        if (expectedLinkCount==actualLinkCount){

            System.out.println(" test Passed");
        }else {
            System.out.println(" test Failed ");
        }


        Thread.sleep(3000);
        driver.quit();
    }
}
