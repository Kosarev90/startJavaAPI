package ru.kosarev.Lesson_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public final Map<String, List<String>> directory = new HashMap<>();

    public void add(String name, String phone) {
        List<String> phoneNumbers = directory.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phone);
        directory.put(name, phoneNumbers);
    }

    public List<String> get(String name) {
        return directory.getOrDefault(name, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Косарев", "1213123442");
        phoneBook.add("Кравчук", "432343332");
        phoneBook.add("Косарев", "555555555");
        phoneBook.add("Чернова", "1111111111");

        List<String> kosarevPhones = phoneBook.get("Косарев");
         System.out.println("Номера телефона Косарев: " + kosarevPhones);


        List<String> kravchukPones = phoneBook.get("Кравчук");
        System.out.println("Номера телефонов Петров: " + kravchukPones);

        List<String> chernovaPhone = phoneBook.get("Чернова");
        System.out.println("Номера телефонов Чернова: " + chernovaPhone);
    }
}
