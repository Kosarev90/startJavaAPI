package ru.kosarev.lesson_1;

import java.util.ArrayList;
import java.util.Scanner;

//        1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
//        2) Вывести все простые числа от 1 до 1000
//        3) Реализовать простой калькулятор
//        4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
//        Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
public class Example {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean play = true;
        while (play) {
            System.out.println("-------------------------------");
            System.out.println("1 - Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)");
            System.out.println("2 - Вывести все простые числа от 1 до 1000");
            System.out.println("0 - Выход из домашнего задания");
            System.out.println("-------------------------------");
            Example example = new Example();
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Выберете решение задачи: ");
            int value = scanner1.nextInt();

            switch (value) {
                case 1 -> example.task1();
                case 2 -> example.task2();
                case 0 -> {
                    play = false;
                    System.out.println("Работа окончена!");
                }
            }
        }
    }

    public void task1() {

        System.out.print("Что бы вычислить треугольного число, введитете натуральное число: ");
        int n = scanner.nextInt();
        if (n > 0) {
            int triangularNumber = (n * (n + 1)) / 2;
            System.out.printf("Треугольное число, числа %d, состовляет %d\n", n, triangularNumber);
        } else System.out.println("Введите число больше 0");
    }

    public void task2() {
        ArrayList<Integer> simpleNumber = new ArrayList<>();
        int n = 1000;
        for (int i = 2; i <= n; i++) {
            if (isSimple(i)) {
                simpleNumber.add(i);
            }
        }
        System.out.println("Простые числа от 1 до 1000: ");
        System.out.println(simpleNumber);
    }
    public static boolean isSimple(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
