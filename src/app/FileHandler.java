package app;

//Імпортуємо клас IOException, щоб обробляти помилки при роботі з файлами

import java.io.IOException;
//Імпортуємо виняток, який виникає, якщо файл вже існує
import java.nio.file.FileAlreadyExistsException;
//Імпортуємо клас Files - для створення, запису та читання файлів
import java.nio.file.Files;
//Імпортуємо клас Path - для створення об’єктів, що вказують шлях до файлів
import java.nio.file.Path;

public class FileHandler {
    //Базовий шлях до директорії, де зберігаються всі файли
    private static final String BASE_PATH = "files/";

    //Метод для створення директорії files/
    public String createDirectory() {
        //Створюємо об'єкт шляху
        Path directory = Path.of(BASE_PATH);
        try {
            //Створюємо директорію якщо вона ще не існує
            Files.createDirectories(directory);
        } catch (IOException e) {
            //Помилка або успішне створення
            return "Directory creation failed: " + e.getMessage();
        }
        return "Created directory " + directory;
    }

    //Метод для створення нового файлу в директорії files/
    public String createFile(String fileName) {
        //Повний шлях до файлу
        Path newFile = Path.of(BASE_PATH + fileName);
        try {
            //Створення файлу
            Files.createFile(newFile);
        } catch (FileAlreadyExistsException e) {
            //Якщо файл вже існує
            return "File already exists!";
        } catch (IOException e) {
            //Інші помилки
            return "Something wrong: " + e.getMessage();
        }
        //Успішне створення
        return "Created " + newFile;
    }

    //Метод для запису тексту у файл
    public String writeToFile(String fileName, String content) {
        //Повний шлях до файлу
        Path path = Path.of(BASE_PATH + fileName);
        try {
            //Запис рядка у файл
            Files.writeString(path, content);
        } catch (IOException e) {
            //Помилка запису
            return "Write error: " + e.getMessage();
        }
        //Успішний запис
        return "Recorder in " + path;
    }

    //Метод для читання тексту з файлу
    public String readFromFile(String fileName) {
        Path path = Path.of(BASE_PATH + fileName);
        try {
            //Зчитування тексту з файлу
            return Files.readString(path);
        } catch (IOException e) {
            //Помилка зчитування
            return "Read error: " + e.getMessage();
        }
    }
}



