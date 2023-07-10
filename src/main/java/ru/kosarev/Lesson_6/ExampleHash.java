package ru.kosarev.Lesson_6;

import java.util.HashSet;

public class ExampleHash {

    public static void main(String[] args) {

        HashSet<Cat> cats = new HashSet<>();
        cats.add(new Cat("Барсик", "белый", 4.4));
        cats.add(new Cat("Мурзик", "черный", 3.2));
        cats.add(new Cat("Муська", "рыжий", 2.9));
        cats.add(new Cat("Муська", "рыжий", 2.9));

        System.out.println(cats);

        System.out.println(new Cat("Кот", "белый", 2).equals(new Cat("Кот", "белый", 2)));
    }
}
