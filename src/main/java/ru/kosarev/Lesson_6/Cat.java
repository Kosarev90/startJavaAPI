package ru.kosarev.Lesson_6;

import java.util.Objects;

public class Cat {

    String name;
    String color;
    double weight;

    public Cat(String name, String color, double weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Кот по имени %s, имеет %s цвет шерсти и весит %.2f килограмм.\n", name, color, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Double.compare(cat.weight, weight) == 0 && Objects.equals(name, cat.name) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, weight);
    }
}
