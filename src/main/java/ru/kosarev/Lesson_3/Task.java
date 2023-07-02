package ru.kosarev.Lesson_3;

//Пусть дан произвольный список целых чисел.
//        1) Нужно удалить из него чётные числа
//        2) Найти минимальное значение
//        3) Найти максимальное значение
//        4) Найти среднее значение

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Task {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введи размер массива: ");
        int size = scanner.nextInt();
        ArrayList<Integer> list = createList(size);
        System.out.println(list);
        System.out.println("Удаление четных чисел: ");
        removeEvenNumbers(list);
        System.out.println(list);
        System.out.print("Нахождение максимального числа: ");
        System.out.println(Collections.max(list));
        System.out.print("Нахождение минимального числа: ");
        System.out.println(Collections.min(list));
        System.out.print("Нахождение среднего значения: ");
        double avg = averageList(list);
        System.out.println(avg);

    }

    public static double averageList(ArrayList<Integer> list) {
        int sum = 0;
        for (int n : list)
            sum += n;

        return (double)sum/list.size();
    }

    public static ArrayList<Integer> createList(int size) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }

    public static void removeEvenNumbers(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++)
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
    }
}
