
public class UdemyChallenges {
    public static void main(String[] args) {
        //Creating double variable
        double valueDouble = 20.00;
        //Create second double variable
        double valueDoubleSecond = 80.00;

        //Adding both numbers together and then multiply by 100
        double sumPlusMult = (valueDouble+valueDoubleSecond) * 100;


        //Step 4 using remainder operator to figure out what the remainder from the result
        //
        double remainderValue = sumPlusMult % 40.00;


        //Step 5: Create a boolean variable that assigns the value
        //true, if the remainder in step four is 0.00, or false if it's not zero.

        boolean remainderBoolean = remainderValue == 0.00 ? true : false;


    }
}
