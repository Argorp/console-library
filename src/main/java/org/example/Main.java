package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Library library;
    static String author;
    static String name;
    static boolean play;

    public static void main(String[] args) {
        library = new Library();
        Scanner input = new Scanner(System.in);
        play = true;

        while (play) {
            System.out.print(
                    """
                    
                    Выберите действие:
                    1. Посмотреть книги
                    2. Взять книгу
                    3. Вернуть книгу
                    4. Пожертвовать библиотеке книгу
                    5. Найти все книги конкретного автора 
                    6. Выйти
                    Введите цифру действия, которое выбрали:
                    """
            );
            String answer = input.nextLine();
            switch (answer) {
                case ("1"):
                    System.out.println("Вот список книг, которые есть в нашей библиотеке");
                    for (Book book : library.getBooks()) {
                        if (book.getIsThere()) System.out.println(book);
                    }
                    break;
                case ("2"):
                    System.out.println("Какую книгугу вы хотите взять?");
                    System.out.print("Автор: ");
                    author = input.nextLine();
                    System.out.print("Название: ");
                    name = input.nextLine();
                    if (library.containsBook(name, author)) {
                        library.borrowBook(name, author);
                        System.out.println("Книга успешно взята.\nСпасибо что ходите к нам в библиотеку");
                    } else {
                        System.out.println("К сожелению такая книга не найдена😞");
                    }
                    break;


                case ("3"):
                    System.out.println("Какую именно книгу вы хотите вернуть?");
                    System.out.print("Автор: ");
                    author = input.nextLine();
                    System.out.print("Название: ");
                    name = input.nextLine();
                    if (library.containsBook(name, author)) {
                        library.returnBook(name, author);
                        System.out.println("Книга успешно возращена.\nСпасибо что ходите к нам в библиотеку");
                    } else {
                        System.out.println("Извините, но такой книги мы вам не давали");
                    }
                    break;
                case ("4"):
                    System.out.println("Какую книгу вы хотите пожертвовать библиотеке?");
                    System.out.print("Автор: ");
                    author = input.nextLine();
                    System.out.print("Название: ");
                    name = input.nextLine();
                    System.out.println("Спасибо за вашу книгу. Библиотеку очень сильно ценит помощь!");
                    library.addBook(name, author);
                    break;
                case ("5"):
                    System.out.print("Введите имя автора: ");
                    String answer2 = input.nextLine();
                    ArrayList<Book> search = library.searchBooks(answer2);
                    if (!search.isEmpty()) {
                        System.out.println("Вот список книг автора " + answer2);
                        for (Book book : search)
                            if (book.getIsThere()) System.out.println(book);
                    } else {
                        System.out.println("Такого автора не обнаружено");
                    }
                    break;


                case ("6"):
                    System.out.println("До свидания");
                    play = false;
                    break;
            }
        }
        System.out.println("Система завершила свою работу");
    }

}
