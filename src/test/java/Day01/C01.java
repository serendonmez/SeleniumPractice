package Day01;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sql.rowset.WebRowSet;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver",
                "src/main/KurulumDosyalari/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://googlechromelabs.github.io/chrome-for-testing/");

       String actualTitle =  driver.getTitle();
        String expectedTitle= "Chrome for Testing availability";

        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println(" Title Test passed");
        }else  {
            System.out.println("title test failed ");
        }

        Thread.sleep(3000);
        driver.quit();


    }
}
