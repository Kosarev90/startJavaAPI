package ru.kosarev.Lesson_4;

//1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.


import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Task_1 {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Введи элементы для сохранения в список: ");
        LinkedList<String> list = new LinkedList<>();

        while (true){
            String str = scanner.nextLine();
            if(str.isEmpty())
                break;
            else list.add(str);
        }

        LinkedList<String> reverseList = reverseLinkedList(list);
        System.out.println("Перевернутный список: ");
        System.out.println(reverseList);
    }

    public static LinkedList<String> reverseLinkedList(LinkedList<String> list) {

        Stack<String> stack = new Stack<>();

        for (String str : list) {
            stack.push(str);
        }

        LinkedList<String> reverse = new LinkedList<>();

        while (!stack.isEmpty()) {
            reverse.add((stack.pop()));
        }
        return reverse;
    }

}
