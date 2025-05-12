package app;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        //Створення об'єкта FileHandler
        FileHandler handler = new FileHandler();
        //Ім'я файлу та вміст для запису
        String fileName = "mylife.txt";
        String content = "Super information.";

//Використовуємо метод getOutput для виводу кожного результату
        getOutput(handler.createDirectory());
        getOutput(handler.createFile(fileName));
        getOutput(handler.writeToFile(fileName, content));
        getOutput("CONTENT: " + handler.readFromFile(fileName));
    }
//Метод для виводу рядка на екран
    private static void getOutput(String output) {
        System.out.println(output);
    }
}