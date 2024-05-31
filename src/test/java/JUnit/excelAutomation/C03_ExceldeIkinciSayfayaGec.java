package JUnit.excelAutomation;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class
C03_ExceldeIkinciSayfayaGec {



@Test
    public void test() throws IOException {

        // ulkeler excelindeki 2. sf ya git
        // son satir indexinin 19 oldugunu test et
        //fiziki olarak kullanilan satir sayisinin8 oldugunu test edelim


        String dosyaYolu= "src/test/java/JUnit/excelAutomation/ulkeler.xlsx";

        FileInputStream fileInputStream= new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        Sheet sayfa2= workbook.getSheet("Sayfa2");

        System.out.println("son satir indexi : ");
        System.out.println(sayfa2.getLastRowNum());//19
        int expectedSatir= 19;
        int actualSatir=sayfa2.getLastRowNum();

    Assertions.assertEquals(expectedSatir,sayfa2.getLastRowNum());


    // physical num excel dosyasinda bos birakilan satir varsa onlari saymadan
    //  kullanilan satir sayisini verir.

        System.out.println("fiziksel kullanilan son satir");
        System.out.println(sayfa2.getPhysicalNumberOfRows());//8


    // bos birakilan satirdaki hucreyi yazdirmak istersek
    // bos birakilan satirlari java row olarak olusturmaz
    // olmayan bir row'dan cell bilgisi istersek NPE olur



    // LastRow ise en son kullanilan satiri verir.
    System.out.println("14. bos satiri yazdiralim ");
    System.out.println(sayfa2.getRow(15)); //null

// varolan Row da kullanilmayan Cell i yazdiralim 17.satir 2. cell

    System.out.println(sayfa2.getRow(16).getCell(1)); //null


}
}
