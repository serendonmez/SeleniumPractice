package SelfLearning;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C028_actions extends TestBaseAll {

    @Test

    public void Test(){
        /*
    1- https://testotomasyonu.com/droppable adresine gidelim
    2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
    3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    4- Sayfayi yenileyin
    5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
    6- “Drop Here” yazisinin degismedigini test edin
     */

//1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        ReusableMethods.bekle(3);
        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement accept= driver.findElement(By.xpath("//*[@id='draggable2']"));
       WebElement dropHere= driver.findElement(By.xpath("//*[@id='droppable2']"));
       actions.dragAndDrop(accept,dropHere).perform();
       //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        ReusableMethods.bekle(1);

        WebElement droppedText= driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String expectedDroppedText = "Dropped!";
        String actualDroppedText= droppedText.getText();
        Assertions.assertEquals(expectedDroppedText,actualDroppedText);

        //Sayfayi yenileyin

        ReusableMethods.bekle(1);

        driver.navigate().refresh();

        ReusableMethods.bekle(1);


        // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        ReusableMethods.bekle(1);
      WebElement notAcceptable=  driver.findElement(By.xpath("//*[@id='draggable-nonvalid2']"));
        ReusableMethods.bekle(1);
        dropHere= driver.findElement(By.xpath("//*[@id='droppable2']"));
        ReusableMethods.bekle(1);
      actions.dragAndDrop(notAcceptable,dropHere).perform();

      //6- “Drop Here” yazisinin degismedigini test edin

        ReusableMethods.bekle(1);
        WebElement ikinciDroppedHere= driver.findElement(By.xpath("//*[@id='droppable2']"));

        String ikinciDroppedHereText= ikinciDroppedHere.getText();
        String dropHereText= "Drop Here";
        Assertions.assertEquals(dropHereText,ikinciDroppedHereText);


    }
}
