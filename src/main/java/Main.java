import java.time.LocalTime;

/* (C)2024 */
public class Main {
    public static void main(String[] args) {
        byte smallNumber = 127;
        LocalTime dateToPrint = LocalTime.ofSecondOfDay(2000);


        //Question mark challenge
        char mySimpleChar = '?';
        char myUnicodeChar = '\u003F';
        char myDecimalChar = 63;

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


}
