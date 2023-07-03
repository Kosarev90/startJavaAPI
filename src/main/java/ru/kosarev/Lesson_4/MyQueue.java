package ru.kosarev.Lesson_4;

import java.util.LinkedList;

class MyQueue {
    private LinkedList<Object> elements = new LinkedList<>();

    public MyQueue() { }
    public MyQueue(LinkedList<Object> linkedList) {
        this.elements = linkedList;
    }
    /**
     * помещает элемент в конец очереди
     */
    public void enqueue(Object element){
        elements.addLast(element);
    }

    /**
     * возвращает первый элемент из очереди и удаляет его
     */
    public void dequeue(){
        elements.removeFirst();
    }

    /**
     * возвращает первый элемент из очереди, не удаляя
     */
    public void first(){
        elements.getFirst();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(23);
        myQueue.enqueue("Java");
        myQueue.enqueue("Russia");
        myQueue.dequeue();
        myQueue.first();

        System.out.println(myQueue.elements);
    }
}
