package ru.kosarev.lesson_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {

    static File fileLog;
    static FileWriter fileWriter;

    public static void main(String[] args) {

        fileLog = new File("log.txt");
        try {
            fileWriter = new FileWriter(fileLog, true);
            boolean work = true;

            while (work) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите первое число: ");
                double d1 = Double.parseDouble(scanner.nextLine());
                System.out.print("Введите второе число: ");
                double d2 = Double.parseDouble(scanner.nextLine());
                System.out.println("Выберите операцию: + - * /");
                System.out.println("! - выход из калькулятора");
                char operator = scanner.next().charAt(0);

                double result = 0;

                String logEntry = String.format("%f %c %f = ", d1, operator, d2);

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
                        System.out.println("Выберите правильный символ");
                        continue;
                    }
                }

                if (operator != '!') {
                    String logResult = String.format("%f", result);
                    fileWriter.write(logEntry + logResult);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.flush();
                }

                System.out.printf("Результат: %f\n", result);
                System.out.println("-----------------------");
            }

            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
