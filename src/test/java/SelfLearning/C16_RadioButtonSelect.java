package SelfLearning;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C16_RadioButtonSelect {

    /*
Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
 a. Verilen web sayfasına gidin.
      https://testotomasyonu.com/form
 b. Cinsiyet Radio button elementlerini locate edin
 c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
 d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
 */

    static WebDriver driver;


    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/form");

        //Cinsiyet Radio button elementlerini locate edin

    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    // test leri mümkün oldugunca bagimsiz yazmak gerekir

    @Test
    @Order(1)
    public void yazidanSecim() throws InterruptedException {
        //Cinsiyet Radio button elementlerini locate edin

        WebElement kadinRadioButton = driver.findElement(By.xpath("//*[@value='option1']"));
        /* WebElement erkekRadioButton =driver.findElement(By.xpath("//*[@*='radio'])[2]")); //*[@value='option1']
         WebElement digerRadioButton =driver.findElement(By.xpath("//*[@*='radio'])[3]"));*/

        Thread.sleep(3000);

        //  c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin


        kadinRadioButton .click();

        Assertions.assertTrue(kadinRadioButton .isSelected());

    }

    @Test @Order(2)
    public void digerleri(){

        WebElement erkekYazi= driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        WebElement digerYazi=driver.findElement(By.xpath("//*[@for='inlineRadio3']"));

        Assertions.assertFalse(erkekYazi.isSelected()&&digerYazi.isSelected(), "failed");




    }

}
