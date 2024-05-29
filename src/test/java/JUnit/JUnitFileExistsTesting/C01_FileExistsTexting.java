package JUnit.JUnitFileExistsTesting;

import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExistsTexting extends TestBaseAll {
    @Test
    public void test (){

    // dosyanin projemizde olup olmadigi testini söyle yapariz:
        // dosya yolunu path content rrot ile aliriz.

        String dosyaYolu="src/test/java/JUnit/JUnitFileExistsTesting/upload.png";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println(dosyaYolu);


    }
}
