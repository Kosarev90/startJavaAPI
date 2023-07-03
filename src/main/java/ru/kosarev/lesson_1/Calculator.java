package ru.kosarev.lesson_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    static File fileLog;
    static FileWriter fileWriter;
    static Stack<String> logStack = new Stack<>();
    static double backResult;

    public static void main(String[] args) {

        fileLog = new File("C:\\startJavaAPI\\src\\main\\java\\ru\\log.txt");
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
                System.out.println("z - отмена последней операции");
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
                        System.out.println("Закончено, удачи!");
                    }
                    case 'z' -> {
                        if (!logStack.isEmpty()) {
                            logStack.pop();
                            System.out.println("Последняя операция отменена");
                        } else {
                            System.out.println("Нет операции для отмены.");
                        }
                        continue;
                    }
                    default -> {
                        System.out.println("Выберите правильный символ");
                        continue;
                    }
                }

                if (operator != '!') {
                    logStack.push(logEntry + result);
                    fileWriter.write(logEntry + result);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.flush();
                    backResult = result;
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