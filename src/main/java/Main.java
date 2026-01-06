import java.time.LocalTime;

/* (C)2024 */
public class Main {
    public static void main(String[] args) {
        byte smallNumber = 127;
        System.out.println("printing small number for testing purposes: " + smallNumber);
        LocalTime dateToPrint = LocalTime.ofSecondOfDay(2000);
        System.out.println("printing small number for testing purposes: " + dateToPrint);


        //Question mark challenge
        char mySimpleChar = '?';
        char myUnicodeChar = '\u003F';
        char myDecimalChar = 63;
        System.out.print("My char values are: " + mySimpleChar + " " + myUnicodeChar + " " + myDecimalChar);

    }
}
