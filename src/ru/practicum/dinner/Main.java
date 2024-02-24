package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Всего хорошего и до свидания");
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        // добавьте новое блюдо
         if (dc.addNewDish(dishType, dishName)){
             System.out.println("Блюдо добавлено в меню");
         } else {
             System.out.printf("Блюдо '%s' уже есть в категории: '%s'%n", dishName, dishType);
         }
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        //scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        List<String> comboDishTypes = new ArrayList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()){
            String dishType = scanner.nextLine();
            if (!dishType.equals("")){
                if (dc.isDishTypeExist(dishType)) {
                    comboDishTypes.add(dishType);
                } else {
                    System.out.printf("Тип блюда '%s' нет в меню%n", dishType);
                }
            } else {
                break;
            }
        }

        // сгенерируйте комбинации блюд и выведите на экран
        List<List<String>> combos = dc.generateDishCombo(numberOfCombos, comboDishTypes);
        for (int i = 0; i < combos.size(); i++) {
            System.out.printf("Комбо %s: %n", (i+1));
            StringJoiner stringJoiner = new StringJoiner(", ");
            for (String dish : combos.get(i)){
                stringJoiner.add(dish);
            }
            System.out.printf("[%s] %n", stringJoiner);
        }

    }
}
