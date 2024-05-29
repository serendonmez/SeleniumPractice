package SelfLearning;

public class Grader {



    public char determineLetterGrade (int numberGrade){

        // methodu olusturduktan sonra CTRL +Shift + T ile Test classi olusturabiliriz.
        if (numberGrade<0){ // sayidan kücük herhangi bir sayi neg old icin illegalArg atariz
        throw new IllegalArgumentException("number grade cannot available");

        } else if (numberGrade<60) {

            return 'F';
        } else if (numberGrade<70) {

            return 'D';

        } else if (numberGrade<80) {

            return 'C';

        }else if (numberGrade<90){
            return 'B';

        }else return 'A';


    }
}
