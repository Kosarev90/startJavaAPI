package ru.kosarev.lesson_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


//2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class BubbleArray {

    public static void main(String[] args) {
        System.out.print("Введи размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = createArray(size);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("bubbleLog.txt");
            fileWriter.write("Начальный массив: " + Arrays.toString(array) + "\n");

            bubbleSort(array, fileWriter);

            fileWriter.write("Отсортированный массив: " + Arrays.toString(array) + "\n");
            System.out.println("Сортировка завершена. Результаты сохранены");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void bubbleSort(int[] array, FileWriter fileWriter) throws IOException {
        int n = array.length;
        boolean swapp;

        for (int i = 0; i < n - 1; i++) {
            swapp = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapp = true;
                }
            }
            fileWriter.write("Итерация " + (i + 1) + ": " + Arrays.toString(array) + "\n");

            if (!swapp) {
                break;
            }
        }
    }

    public static int[] createArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            int n = random.nextInt(100);
            array[i] = n;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
