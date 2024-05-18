package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Locators_ById {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/main/KurulumDosyalari/chromedriver-win64/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Testotomasyonu sf ina git

        driver.get("https://testotomasyonu.com/");



        // arma kutusunu locate et bir webelement olrak tanimla

      WebElement aramaKutusu = driver.findElement(By.id("global-search"));


        // arama kutusuna phone yazip arat

        aramaKutusu.sendKeys("phone");

        Thread.sleep(3000);

        // enter a basmak icik

        aramaKutusu.submit();


        Thread.sleep(3000);

        driver.quit();
    }
}
