package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        //"panel-list"

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com/search-product?search=dress&search_category=0");

        List<WebElement> category=  driver.findElements(By.className("panel-list"));

        System.out.println(category.size());  //8

       //  System.out.println(category); listin icinde Web Element old icin sout ref degeri döndürpr

        for ( WebElement each :category   ) {
            System.out.println(each.getText());
        }


        Thread.sleep(3000);
        driver.quit();


    }
}
