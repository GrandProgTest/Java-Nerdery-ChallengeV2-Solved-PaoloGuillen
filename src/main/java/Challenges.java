/* (C)2024 */
import java.io.Console;
import java.math.BigInteger;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/* (C)2024 */
public class Challenges {

    /* *****
    Challenge 1

    "Readable Time"

    The function "readableTime" accepts a positive number as argument,
    you should be able to modify the function to return the time from seconds
    into a human readable format.

    Example:

    Invoking "readableTime(3690)" should return "01:01:30" (HH:MM:SS)
    ***** */

    public String readableTime(Integer seconds) {


        Integer minutes = seconds / 60;
        Integer hours = minutes / 60;
        Integer remainingMinutes = minutes % 60;
        Integer remainingSeconds = seconds % 60;
        String appendedString = "";
        appendedString += betterAppended(hours,false);
        appendedString += betterAppended(remainingMinutes,false);
        appendedString += betterAppended(remainingSeconds,true);
        return  appendedString;

    }
    public String betterAppended(Integer n, boolean isSeconds)
    {
        String appendedString = "";

        if(n > 10)
        {
            appendedString += Integer.toString(n) + (isSeconds ? "" : ":");
        }
        else
        {
            appendedString += "0" + n + (isSeconds ? "" : ":");
        }
        return appendedString;
    }

    /* *****
    Challenge 2

    "Circular Array"

    Given the following array "COUNTRY_NAMES", modify the function "circularArray"
    to return an array that meets the following criteria:

    - The index number passed to the function should be the first element in the resulting array
    - The resulting array must have the same length as the initial array
    - The value of the argument "index" will always be a positive number

    Example:

    Invoking "circularArray(2)" should return "["Island", "Japan", "Israel", "Germany", "Norway"]"
    ***** */

    public String[] circularArray(int index) {
        String[] COUNTRY_NAMES = {"Germany", "Norway", "Island", "Japan", "Israel"};
        int length = COUNTRY_NAMES.length;

        index = index % length;

        String[] result = new String[length];

        System.arraycopy(COUNTRY_NAMES, index, result, 0, length - index);
        System.arraycopy(COUNTRY_NAMES, 0, result, length - index, index);

        return result;
    }
    ;

    /* *****
    Challenge 3

    "Own Powers"

    The function "ownPower" accepts two arguments. "number" and "lastDigits".

    The "number" indicates how long is the series of numbers you are going to work with, your
    job is to multiply each of those numbers by their own powers and after that sum all the results.

    "lastDigits" is the length of the number that your function should return, as a string!.
    See example below.

    Example:

    Invoking "ownPower(10, 3)" should return "317"
    because 1^1 + 2^2 + 3^3 + 4^4 + 5^5 + 6^6 + 7^7 + 8^8 + 9^9 + 10^10 = 10405071317
    The last 3 digits for the sum of powers from 1 to 10 is "317"
    ***** */
    public String ownPower(int number, int lastDigits) {

        BigInteger poweredNumber = BigInteger.ZERO;

        for (int i = 1; i <= number; i++) {
            poweredNumber = poweredNumber.add(
                    BigInteger.valueOf(i).pow(i)
            );
        }

        BigInteger mod = BigInteger.TEN.pow(lastDigits);

        String s = poweredNumber.mod(mod).toString();
        s = String.format("%0"+ lastDigits + "d",new BigInteger(s));
        return s;


    }
    ;

    /* *****
    Challenge 4

    "Sum of factorial digits"

    A factorial (x!) means x! * (x - 1)... * 3 * 2 * 1.
    For example: 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800

    Modify the function "digitSum" to return a number that
    equals to the sum of the digits in the result of 10!

    Example:

    Invoking "digitSum(10)" should return "27".
    Since 10! === 3628800 and you sum 3 + 6 + 2 + 8 + 8 + 0 + 0
    ***** */

    public Integer digitSum(int n) {

        BigInteger factorial = factorialFunctionBigInteger(n);
        String factorialString = factorial.toString();

        Integer digitSum = 0;

        for (int i = 0; i < factorialString.length(); i++)
        {
            digitSum += Character.getNumericValue(factorialString.charAt(i));
        }
        return digitSum;
    }
    public BigInteger factorialFunctionBigInteger(int n) {
        BigInteger factorialResult = BigInteger.ONE;

        while (n > 1) {
            factorialResult = factorialResult.multiply(BigInteger.valueOf(n));
            n--;
        }

        return factorialResult;
    }

    /**
     * Decryption.
     * Create a decryption function that takes as parameter an array of ASCII values. The addition between values is the ascii value decrypted.
     * decrypt([ 72, 33, -73, 84, -12, -3, 13, -13, -68 ]) ➞ "Hi there!"
     * H = 72, the sum of H 72 and 33 gives 105 which ascii value is i;
     * The function must return the string encoded using the encryption function below.
     *
     * @param ascivalues  hand, player2 hand
     */
    public String decrypt(List<Integer> ascivalues) {
        String arrayDecrypted = "";
        int lastSum = (int) ascivalues.getFirst();
        for(int i = 0; i<ascivalues.size();i++)
        {
            if(i == 0){
                arrayDecrypted+= (char) (int) ascivalues.get(i);
            }
            else {
                lastSum = (int) ascivalues.get(i) + lastSum;
                arrayDecrypted += (char) (int) lastSum;
            }
        }
        return arrayDecrypted;
    }

    /**
     * Encryption Function.
     * Create am encryption function that takes a string and converts into an array of ASCII character values.
     * encrypt("Hello") ➞ [72, 29, 7, 0, 3]
     * // H = 72, the difference between the H and e is 29
     * The function must return an array of integer ascii values.
     *
     * @param text  hand, player2 hand
     */
    public List<Integer> encrypt(String text) {

        List<Integer> encryptedList = new ArrayList<>();
        int lastSubstraction;

        for(int i = 0; i < text.length(); i++)
        {

            if(i == 0){
                encryptedList.add((int)(text.charAt(i)));
            }
            else {
                lastSubstraction = (int)(text.charAt(i)) - (int)(text.charAt(i-1));

                encryptedList.add((int)(lastSubstraction));
            }
        }

        return encryptedList;
    }
}
