package JUnit.excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C05_ExceliMapOlarakKaydet {




    @Test



    public void Test() throws IOException {


        // kayitli ulkeler arasinda Netherlands olduugnu test edin.

        String dosyaYolu="src/test/java/JUnit/excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);



       Sheet sayfa1= workbook.getSheet("Sayfa1");

        int sonSatirNum= sayfa1.getLastRowNum();

        // ingilizce ulke ve baskent isimlerini bir mape kaydedelim

        Map<String, String > ulkeBaskent= new TreeMap<>();

        for (int i = 0; i <sonSatirNum ; i++) {

                String ulkeler = sayfa1.getRow(i).getCell(0).toString();
                String baskenkentler= sayfa1.getRow(i).getCell(1).toString();

                ulkeBaskent.put(ulkeler,baskenkentler);

        }

        Assertions.assertTrue(ulkeBaskent.containsKey("Netherlands"));







    }
}
