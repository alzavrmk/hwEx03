
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите данные одной строкой в формате: " +
                    "Фамилия Имя Отчество дата рождения(dd.mm.yyyy) номер телефона пол(f или m):");
            String strIn = iScanner.nextLine();
            int indexNum = indexOfNumber(strIn);
            if (indexNum == 1) {
                break;
            } else{
                System.out.printf("код ошибки: %d. ", indexNum);
                decoder(indexNum);
            }
        }
        iScanner.close();

    }
    public static int indexOfNumber(String strIn) {
        int countWords = 6;
        String [] words= strIn. split (" ");
        System.out.println(words[0]);
        if (words.length < countWords){
            return -1;
        }
        if (words.length > countWords){
            return -2;
        }
        return 1;
    }

    public static void decoder(int code) {
        switch (code) {
            case -1:
                System.out.println("Введены не все данные!");
                break;
            case -2:
                System.out.println("Введенна излишняя информация!");
                break;
//            default:
//                System.out.println("Данные введены корректно!");
        }
    }

    static String StrOut(String strIn){
        return " ";

    }
    private static String WriterFileName(String strOut) {
        return " ";
    }
}