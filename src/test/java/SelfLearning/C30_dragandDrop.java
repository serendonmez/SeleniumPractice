package SelfLearning;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C30_dragandDrop extends TestBaseAll {

    @Test
    public void test(){



         /*
    1- https://testotomasyonu.com/droppable adresine gidelim
2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
4- Sayfayi yenileyin
5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
6- “Drop Here” yazisinin degismedigini test edin
     */


        driver.get("https://testotomasyonu.com/droppable");
        ReusableMethods.bekle(1);

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim


        WebElement acceptelementi= driver.findElement(By.xpath("//*[@id='draggable2']"));
        WebElement droppableElementi=driver.findElement(By.xpath("//*[@id='droppable2']"));
        ReusableMethods.bekle(1);
        Actions actions=new Actions( driver);
        actions.dragAndDrop(acceptelementi,droppableElementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement dropped= driver.findElement(By.xpath("//*[text()='Dropped!']"));

        ReusableMethods.bekle(1);

        String actualDroppedText= dropped.getText();
        String expectedText= "Dropped!";
        Assertions.assertEquals(expectedText,actualDroppedText);
        // 4- Sayfayi yenileyin

        driver.navigate().refresh();

        //“Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement notAcceptable= driver.findElement(By.id("draggable-nonvalid2"));
        ReusableMethods.bekle(1);

        droppableElementi=driver.findElement(By.xpath("//*[@id='droppable2']"));

        actions.dragAndDrop(notAcceptable,droppableElementi).perform();

        ReusableMethods.bekle(1);

        //“Drop Here” yazisinin degismedigini test edin

        String dropHereText= droppableElementi.getText();

        System.out.println(dropHereText);

        String expectedDropHereText="Drop Here";

        Assertions.assertEquals(expectedDropHereText,dropHereText);


    }
}
