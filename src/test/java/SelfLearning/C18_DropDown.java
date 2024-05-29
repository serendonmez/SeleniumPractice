package SelfLearning;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C18_DropDown extends TestBaseAll {



    /*
    ● https://testotomasyonu.com/form adresine gidin.
	1.Index kullanarak Option 1 secin ve yazdirin
	2. Value kullanarak Option 2 secin ve yazdirin
	3. VisibleText kullanarak Option 1 secin ve yazdirin
	4. Tüm dropdown degerlerini yazdirin
	5.Dropdown un boyutunun 4 old test edin
     */

    @Test

    protected void toTest() {

        driver.get("https://testotomasyonu.com/form");

        WebElement gun= driver.findElement(By.xpath("(//select[@*='form-control'])[1]"));
        Select select = new Select(gun);
        select.selectByIndex(1);

        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("1");
        System.out.println(select.getFirstSelectedOption().getText());

        ReusableMethods.listYazdir(select.getOptions());
        System.out.println();



        int dropdownBoyut= select.getOptions().size();
        System.out.println(dropdownBoyut);

        ReusableMethods.bekle(3);
    }

}
