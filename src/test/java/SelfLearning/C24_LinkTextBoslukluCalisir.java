package SelfLearning;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C24_LinkTextBoslukluCalisir extends TestBaseEach {

    @Test
    @Order(1)
    public void linkTextTest(){

        driver.get("https://www.testotomasyonu.com/category/4/products");

        driver.findElement(By.linkText("Sign Up Now")).click();

        // link text locate alirken text ten sf da birden fazla varsa
        // index yardimci olmaz baska bir attribute denenmeli






        ReusableMethods.bekle(3);

    }



}
