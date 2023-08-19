import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        List<String> family = new ArrayList<>();
        family.add("Банщикова");
        while (true) {
            System.out.println("Введите данные одной строкой в формате: " +
                    "Фамилия Имя Отчество дата рождения(dd.mm.yyyy) номер телефона пол(f или m):");
            String strIn = iScanner.nextLine();
            int indexNum = indexOfNumber(strIn);
            if (indexNum == 1) {
                try{
                    StringBuilder stringOut= strOut(strIn);
                    System.out.println(stringOut);
                    String filename = strIn.split(" ")[0];
                    System.out.println(family);

                    for (String s: family) {
                        if (s.equals(filename)){
                            appendFileFamily(filename,stringOut);
                    } else{
                            family.add(s);
                            writerFileFamily(filename,stringOut);
                        }


                    }

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
        String [] words= strIn.split (" ");
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
        }
    }

    static StringBuilder strOut(String strIn){
        String [] words= strIn. split (" ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 3; i++) {
                str.append(words[i]+" ");
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
    static void writerFileFamily(String filename, StringBuilder strOut) {

        try (FileWriter fw = new FileWriter(filename+".txt")){
            fw.append(strOut+"\n");
       } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void appendFileFamily(String filename,StringBuilder strOut) {
        try (FileWriter fw = new FileWriter(filename+".txt", true)) {
            fw.append(strOut+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}