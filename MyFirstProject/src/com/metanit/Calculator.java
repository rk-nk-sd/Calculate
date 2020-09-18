package com.metanit;
public class Calculator {
    public static double calculate (int var1, int var2, char oper){
        float result = 0;
        switch (oper){
            case '+': result = var1 + var2; break;
            case '-': result = var1 - var2; break;
            case '*': result = var1 * var2; break;
            case '/': result = var1 / var2; break;
        }
            return result;
    }
}
