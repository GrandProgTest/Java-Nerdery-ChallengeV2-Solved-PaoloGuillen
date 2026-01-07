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

    public boolean hasTeen (int n1,int n2, int n3)
    {
        if(isTeen(n1))
            return true;
        else if (isTeen(n2))
            return true;
        else if (isTeen(n3))
            return true;
        else
            return false;
    }

    public boolean isTeen(int n){
        return (n>=13 && n<=19);
    }

    public static void printNumberInWord(int number){
        switch(number)
        {
            case 0 -> System.out.println("ZERO");
            case 1 -> System.out.println("ONE");
            case 2 -> System.out.println("TWO");
            case 3 -> System.out.println("THREE");
            case 4 -> System.out.println("FOUR");
            case 5 -> System.out.println("FIVE");
            case 6 -> System.out.println("SIX");
            case 7 -> System.out.println("SEVEN");
            case 8 -> System.out.println("EIGHT");
            case 9 -> System.out.println("NINE");
            default -> System.out.println("OTHER");
        }
    }
}
