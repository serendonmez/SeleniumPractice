package SelfLearning;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_GetPositionGetSize {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("WebDriver.chrome.driver","src/main/KurulumDosyalari/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver. manage().window().maximize();
        System.out.println(" Maximize position :  Pixel olarak"+driver.manage().window().getPosition());
        System.out.println("Max size : "+driver.manage().window().getSize());
        Thread.sleep(3000);
        driver.manage().window().minimize();
        System.out.println(" mini"+driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        System.out.println(" full "+driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        Thread.sleep(3000);


        Thread.sleep(3000);
            driver.manage().window().setPosition(new Point(600,300));
            Thread.sleep(3000);

            driver.manage().window().setSize(new Dimension(500,500));

        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());


       // driver.manage().deleteAllCookies();


        Thread.sleep(3000);
        driver.quit();

    }
}
