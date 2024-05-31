package JUnit.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class C01_ExceldeSatirSutunYazdir {



    @Test
    public void test() throws IOException {


        String dosyaYolu= "src/test/java/JUnit/excelAutomation/ulkeler.xlsx";

        FileInputStream fileInputStream= new FileInputStream(dosyaYolu);
        // maven repo dan

        Workbook workbook= WorkbookFactory.create(fileInputStream);
        // olusturdugumuz workbook objesi ile excel i buraya copy yaptik

        Sheet sayfa1= workbook.getSheet("Sayfa1");
        // Excelde Aradigimiz datalari adim adim adreslendirmeliyiz
        // once excel dosyasini tanittik
        // sayfa numaraisini
        // satiri
        // hücre

        Row yuzDoksanUcuncuSatir= sayfa1.getRow(178);

        Cell cell = yuzDoksanUcuncuSatir.getCell(0);

        System.out.println(cell); //Ukraine

        //Sheet, Row, Cell index kullanir.








    }





}
