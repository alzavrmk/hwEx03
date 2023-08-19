//Банщикова Анастаися Александровна 28.06.1980 89143646546 m
import java.time.Year;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите данные одной строкой в формате: " +
                    "Фамилия Имя Отчество дата рождения(dd.mm.yyyy) номер телефона пол(f или m):");
            String strIn = iScanner.nextLine();
//            String[] words = strIn.split(" ");
//            for (int i = 0; i < words.length; i++) {
//                System.out.println(words[i]);
//                if (i == 3){
//                    String[] numDate = words[3].split("\\.");
//                    for (int j = 0; j < numDate.length; j++) {
//                        System.out.println(numDate[j]);
//                    }
//                }
//            }
//
//        }
//    }}
            int indexNum = indexOfNumber(strIn);
            if (indexNum == 1) {
                try{
                    StringBuilder stringOut= strOut(strIn);
                    System.out.println(stringOut);
                }
                catch (IllegalArgumentException e){
                    e.printStackTrace();
                }
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

    static StringBuilder strOut(String strIn){
        String [] words= strIn. split (" ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            //if (words[i] == "/D") {
                str.append(words[i]+" ");
//            } else {
//                throw new IllegalArgumentException("Неверно введено ФИО");
//            }
        }
        String[] numData = words[3].split("\\.");
        if ((parseInt(numData[0]) > 0) && (parseInt(numData[0]) < 32) &&
                (parseInt(numData[1]) > 0) && (parseInt(numData[1]) < 13) &&
                ((parseInt(numData[2]) > 1900) && (parseInt(numData[0]) <  Year.now().getValue()))){
            str.append(numData[0]);
            str.append(".");
            str.append(numData[1]);
            str.append(".");
            str.append(numData[2]+" ");
        }else {
            throw new IllegalArgumentException("Ошибка в дате рождения");
        }
        if (words[4].matches("[0-9]{11}")){
            str.append(words[4]+" ");}
        else {
            throw new IllegalArgumentException("Неверно введен номер телефона!");
        }
        if (words[5].equals("f") || words[5].equals("m")){
            str.append(words[5]);
        }
        else {
            throw new IllegalArgumentException("Неверно введен пол!");
        }
        return str;
    }



    private static String WriterFileName(String strOut) {
        return " ";
    }
}