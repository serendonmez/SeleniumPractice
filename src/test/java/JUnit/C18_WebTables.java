package JUnit;

import Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class C18_WebTables extends TestBaseAll {


@Test
    void webTables(){

    /*
     1."https://testotomasyonu.com/webtables" adresine gidin
2.Web table tum body’sini yazdirin
3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
4. Web table’daki satir sayisinin 5 oldugunu test edin
5. Tum satirlari yazdirin
6. Web table’daki sutun sayisinin 4 olduğunu test edin
7. 3.sutunu yazdirin
8. Tablodaki basliklari yazdirin
9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
     */
driver.get("https://testotomasyonu.com/webtables");

//2.Web table tum body’sini yazdirin


    WebElement tableBody= driver.findElement(By.xpath("//tbody"));
    System.out.println(tableBody.getText());

    //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin

    String expectedText="Comfortable Gaming Chair";
    String actualText= tableBody.getText();

    assertTrue(actualText.contains (expectedText));

//4. Web table’daki satir sayisinin 5 oldugunu test edin

    List<WebElement> satirList= driver.findElements(By.xpath("//tbody/tr"));

    int expectedSatirSayisi= 5;
    int actualSatirSayisi= satirList.size();

    assertEquals(expectedSatirSayisi,actualSatirSayisi);

    //5. Tum satirlari yazdirin

    for ( WebElement each :satirList   ) {
        System.out.print(each.getText()+" \n");
    }

    //6. Web table’daki sutun sayisinin 4 olduğunu test edin

    List <WebElement> sutunSayisi = driver.findElements(By.xpath("//tbody/tr[1]/td"));
     int expectedSutunSayisi= 4 ;
     int actualSutunSayisi= sutunSayisi.size();

     assertEquals(expectedSutunSayisi,actualSutunSayisi);


        //7. 3.sutunu yazdirin

    List<WebElement> ucuncuSutun= driver.findElements(By.xpath("//tbody/tr/td[3]"));
    for ( WebElement each :ucuncuSutun   ) {
        System.out.println(each.getText()+" ");
    }
        //8. Tablodaki basliklari yazdirin


    List<WebElement> tableTitle= driver.findElements(By.xpath("//table//thead"));

    for (WebElement each: tableTitle) {
        System.out.println(each.getText());
    }

    //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

    System.out.println("3/4 cellindeki text : "+receiveCell(3, 4));

    //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

    WebElement category = driver.findElement(By.xpath("//tbody//tr[4]//td[2]"));
    System.out.println("furniture"+category.getText());

    // method ile de cagirabiliriz.

    System.out.println("Furniture : "+receiveCell(4, 2));


}





    public String receiveCell(int satir, int sutun){


    String istenenCell= "//body//tr["+ satir +"]//td["+sutun+"]";

    WebElement cell= driver.findElement(By.xpath(istenenCell));



    return cell.getText();
    }



}
