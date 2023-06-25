package ru.kosarev.lesson_1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        boolean work = true;

        while (work) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введи первое число: ");
            double d1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Введи второе число: ");
            double d2 = Double.parseDouble(scanner.nextLine());
            System.out.println("Выбери операцию: + - * /");
            System.out.println("! - выход из калькулятора");
            char operator = scanner.next().charAt(0);

            double result = 0;

            switch (operator) {
                case '+' -> result = d1 + d2;
                case '-' -> result = d1 - d2;
                case '*' -> result = d1 * d2;
                case '/' -> result = d1 / d2;
                case '!' -> {
                    work = false;
                    System.out.println("До свидания!");
                }
                default -> {
                    System.out.println("выбери верный символ");
                    continue;
                }
            }
            System.out.printf("Результат: %f\n", result);
            System.out.println("-----------------------");
        }
    }
}
