package SelfLearning;

import SelfLearning.Grader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {

// cover edge , null




    @Test
    void fiftyNineShouldReturnF(){

        var grader = new Grader();
        assertEquals('F',grader.determineLetterGrade(59));

    }

    @Test
    void sixtyNineShouldReturnD(){

        var grader = new Grader();
        assertEquals('D',grader.determineLetterGrade(69));

    }

    @Test
    void seventyNineShouldReturnC(){

        var grader = new Grader();
        assertEquals('C',grader.determineLetterGrade(79));

    }

    @Test
    void eightyNineShouldReturnB(){

        var grader = new Grader();
        assertEquals('B',grader.determineLetterGrade(89));

    }
    @Test
    void ninetyNineShouldReturnA(){

        var grader = new Grader();
        assertEquals('A',grader.determineLetterGrade(99));

    }

    @Test
    void eightyShouldReturnB(){

        var grader = new Grader();
        assertEquals('B',grader.determineLetterGrade(80));

    }

    @Test
    void ninetyShouldReturnA(){

        var grader = new Grader();
        assertEquals('A',grader.determineLetterGrade(90));

    }
    @Test
    void seventyShouldReturnC(){

        var grader = new Grader();
        assertEquals('C',grader.determineLetterGrade(70));

    }

    @Test
    void sixtyShouldReturnD(){

        var grader = new Grader();
        assertEquals('D',grader.determineLetterGrade(60));

    }
    @Test
    void fiftyShouldReturnF(){

        var grader = new Grader();
        assertEquals('F',grader.determineLetterGrade(50));

    }

    @Test
    void zeroShouldReturnF(){

        var grader = new Grader();
        assertEquals('F',grader.determineLetterGrade(0));

    }



    @Test
    void negativeShouldReturnIllegalArumentException(){

        var grader = new Grader();
        assertThrows(IllegalArgumentException.class, ()-> {    // lambda
            grader.determineLetterGrade(-1);
        });
    }


                //Test kodlarinda exceeption varsa Failed olur  bunun icin Junitte özel bir assert methodu vardir




}



