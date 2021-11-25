package com.company;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static int op, pls;

    public static String rimout(int var) {
        String[] rim= new String[] {null , "I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String str = "";
        if (var == 100)
            return "C";
        for (int i = 0; i < var / 10; i++ ) {
            str += "X";
        }
        if (var%10 != 0)
            str = str + rim[var%10];
        return str;
    }

    public static int mathpart(int op, int a, int b){
        int result = 0;
        if (op == 1) {
            result = a + b;
        }
        else if (op == 2) {
            result = a - b;
        }
        else if (op == 3) {
            result = a * b;
        }
        else if (op == 4) {
            result = a / b;
        }
        return result;
    }

    public static int choose(String s) {
        int op = 0;
        pls = s.indexOf('+');
        if ( pls != -1)
            op = 1;
        else    {
            pls = s.indexOf('-');
            if ( pls != -1)
                op = 2;
            else {
                pls = s.indexOf('*');
                if ( pls != -1)
                    op = 3;
                else {
                    pls = s.indexOf('/');
                    if ( pls != -1)
                        op = 4;
                    else
                        op = -1;
                }
            }
        }
        return op;
    }

    public static void main(String[] args) {
        int result;
        Scanner num = new Scanner(System.in);
        String str =num.nextLine();
        op = choose(str);
        if (op == -1) {
            System.out.println("throws Exception // Так как строка не является математической операцией");
            return;
        }
        Variable First = new Variable(), Second = new Variable();
        First.str =str.substring(0,pls).trim();
        Second.str =str.substring(pls + 1,str.length()).trim();
        int temp = choose(Second.str);
        if (temp != -1) {
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            return;
        }
        First.checkdata();
        Second.checkdata();
        if (First.intvar == 0 || Second.intvar == 0 ) {
            System.out.println("throws Exception //т.к. одна или обе переменные не подходят для задачи");
            return;
        }
        if ( First.rimcheck == 0 && Second.rimcheck == 0 ) {
            result = mathpart(op, First.intvar, Second.intvar);
            System.out.println(result);
            return;
        } else if ( First.rimcheck == 1 && Second.rimcheck == 1 ) {
            result = mathpart(op, First.intvar, Second.intvar);
            if (result < 1) {
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел(и видимо нуля по заданию)");
                return;
            }
            System.out.println(rimout(result));
            return;

        } else {
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            return;
        }


        //System.out.println("Значение First.str - " + First.str);
        //System.out.println("Значение Second.str - " + Second.str);
        //System.out.println("Значение First.intvar - " + First.intvar);
        //System.out.println("Значение Second.intvar - " + Second.intvar);
        //System.out.println("Значение First.rimcheck - " + First.rimcheck);
        //System.out.println("Значение Second.rimcheck - " + Second.rimcheck);
        //System.out.println("Значение OP - " + op);
    }
}
