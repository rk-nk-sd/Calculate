package com.metanit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer var1 = 0;
        Integer var2 = 0;
        Integer i;
        char oper;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String text = scanner.nextLine();

        text = text.replaceAll("\\s+","");
        text = text.substring(0, text.length());
        String[] blocks = text.split("[+-/*]");

        oper = text.charAt(blocks[0].length());
//---------------------------------------------------

        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabic = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        boolean triggerRomanVar1 = false;
        boolean triggerRomanVar2 = false;
        boolean triggerArabicVar1 = false;
        boolean triggerArabicVar2 = false;

        // Перебор массива roman
        for (i=1; i<roman.length; i++) {
            if(blocks[0].equals(roman[i])) {
                triggerRomanVar1 = true;
                var1 = i;
            }
            if (blocks[1].equals(roman[i])) {
                triggerRomanVar2 = true;
                var2 = i;
            }
        }

        // Перебор массива arabic
        for (i=1; i<arabic.length; i++) {
            if(blocks[0].equals(arabic[i])) {
                triggerArabicVar1 = true;
                var1 = i;
            }
            if (blocks[1].equals(arabic[i])) {
                triggerArabicVar2 = true;
                var2 = i;
            }
        }


//--------------------------------------------------------

        Calculator calc = new Calculator();

        if (triggerRomanVar1 == true && triggerRomanVar2 == true && var1 != 0 && var2 !=0) {
            double result = calc.calculate(var1, var2, oper);
            // Реализовать метод или класс перевода числа с арабской системы счисления в римскую
            int answer = (int) result;

            ArabicToRoman conv = new ArabicToRoman();
            String resultRoman = conv.getRomanNumber(answer);

            if (resultRoman.equals("")) {
                System.out.println("Обработка исключения...");
            } else {
                System.out.println("Ответ:");
                System.out.println(resultRoman);
            }
        } else if (triggerArabicVar1 == true && triggerArabicVar2 == true && var1 != 0 && var2 !=0) {
            double result = calc.calculate(var1, var2, oper);
            System.out.println(result);
        } else {
            System.out.println("Обработка исключения...");
            }
        }
    }