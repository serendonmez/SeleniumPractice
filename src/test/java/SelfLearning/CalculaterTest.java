package SelfLearning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculaterTest {

    @Test
    void twoPlusTwoShouldEqualsFour() {


      //  Calculator calculator= new Calculator();
        var calculator= new Calculator(); // version 10 dan sonra lolusturulan Data türü yerine var
        // kullanmaya izin veriyor

       assertEquals(4, calculator.add(2,2));

        // assertNotNull();



    }

    @Test
    void ThreePlusSixShouldEqualsNine(){

        var calculator = new Calculator();
      assertEquals(9,calculator.add(3,6)); // inputa göre output degisecegi icin
        // testin farkli inputlarla saglamasi yapilmali
        // örnegin yukaridaki testte 2 *2 =4 methoda yanlislikla * yazilmis olsaysi test yine passed olacakti



    }






}
