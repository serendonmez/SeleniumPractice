package Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01_IlkOtomasyon  {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        /*
         <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.20.0</version>  --> version degistirmek icin
            pom da version degistirip güncellemek yeterli
            4.19.1 e gecip güncellenebilir.
            ancak version degisikligi uyum sorunlarina , güvenlik risklerine, performans
            sorunlarina, docu eksikligine neden olabilir.
            version degistirmeden önce yedekleme yapilmasi önerilir
        </dependency>
         */

    }
}
