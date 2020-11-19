package ru.itsjava;
//

import java.util.Scanner;
//
//public class ComputersShop {
//    public static void main(String[] args) {
//        String[] items = new String[]{"Lenovo", "Apple", "HP", "Sony", "Acer", "Asus"};
//        Scanner console = new Scanner(System.in);
//        printMenu();
//        while (true) {
//            System.out.println("Введите номер меню:");
//            int menuNum = console.nextInt();
//            if (menuNum == 1) {
//                printAllModels(items);
//            } else if (menuNum == 2) {
//                items = addModel(items, console);
//            } else if (menuNum == 3) {
//                items = removeModel(items, console);
//            } else if (menuNum == 4) {
//
//            } else if (menuNum == 0) {
//                System.out.println("До скорой встречи!");
//                System.exit(0); // можно ввести return
//            }
//        }
//    }
//
//    private static String[] removeModel(String[] model, Scanner console) {
//        System.out.println("Введите модель, которую хотите купить:");
//        String inputModel = console.next();
//        String[] resModelArray = new String[model.length - 1];
//        for (int i = 0; i < resModelArray.length; i++) {
//            if(!model[i].equalsIgnoreCase(inputModel)){
//                resModelArray[i]= model[i];
//            }
//        }
//        return resModelArray;
//
//
//    }
//
//    private static String[] addModel(String[] model, Scanner console) {
//        System.out.println("Введите новую модель:");
//        String inputModel = console.next();
//        String[] resModelArray = new String[model.length + 1];
//        for (int i = 0; i < model.length; i++) {
//            resModelArray[i] = model[i];
//        }
//        resModelArray[model.length] = inputModel;
//        return resModelArray;
//    }
//
//    private static void printAllModels(String[] items) {
//        for (String model : items) {
//            System.out.print(model + " ");
//        }
//        System.out.println();
//    }
//
//    public static void printMenu() {
//        System.out.println(" Меню:\n" +
//                "1. Посмотреть все модели\n" +
//                "2.  Добавить модель\n" +
//                "3.  Посмотреть и купить\n" +
//                "4.  Отсортировать по алфавиту\n" +
//                "5.\n" +
//                "6.\n" +
//                "0. Выход");
//    }
//
//}
// Меню:
//1. Посмотреть все модели
//2.  Добавить модель
//3.  Посмотреть и купить
//4.  Отсортировать по алфавиту
//5.
//6.
//0. Выход


import java.util.Arrays;
import java.util.Scanner;

public class ComputersShop {
    public static void main(String[] args) {


        String[] items = new String[]{"Lenovo", "Apple", "HP", "Sony", "Acer", "Asus"};
        Scanner console = new Scanner(System.in);
        printMenu();
        while (true) {
            System.out.println("Введите номер меню:");
            int menuNum = console.nextInt();
            if (menuNum == 1) {
                printAllModels(items);
            } else if (menuNum == 2) {
                items = addModel(items, console);
            } else if (menuNum == 3) {
                items = removeModel(items, console);
            } else if (menuNum == 4) {
                bubbleSort(items);
            } else if (menuNum == 5) {
                reversList(items);
            } else if (menuNum == 6) {
                letterFind(items, console);
            } else if (menuNum == 0) {
                System.out.println("До скорой встречи!");
                System.exit(0); // можно ввести return
            }
        }
    }

    private static void bubbleSort(String[] items) {
        for (int j = 0; j < items.length; j++) {
            for (int i = 0; i < items.length - j - 1; i++) {
                if (items[i].charAt(0) > items[i + 1].charAt(0)) {
                    String temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;

                }
            }
        }

    }

    private static void letterFind(String[] items, Scanner console) {
        System.out.println("Введите первую заглавную букву в названии:");
        String letter = console.next();
        char ch = letter.charAt(0);
        for (int i = 0; i < items.length; i++) {
            if (ch == items[i].charAt(0)) {
                System.out.println("Поздравляем, есть такая буква в названии модели: № " + (i + 1) + " " + items[i]);

            } else {
                System.out.println("Данная буква в товаре №" + (i + 1) + " отсутствует!");
            }
        }
    }

    private static void reversList(String[] items) {

        String string = Arrays.toString(items);
        string = string.replaceAll("[\\[\\]]", "");
        String[] listRevers = string.split(",?\\s+");
        for (int i = 0; i < listRevers.length; i++) {
            String revers = listRevers[listRevers.length - i - 1];
            System.out.println(revers);
        }
    }

    private static String[] removeModel(String[] model, Scanner console) {
        System.out.println("Введите модель, которую хотите купить:");
        String inputModel = console.next();
        String[] resModelArray = new String[model.length - 1];
        int delIndex = -1;
        for (int i = 0; i < resModelArray.length; i++) {
            if (inputModel.equalsIgnoreCase(model[i])) {
                delIndex = i;
                break;
            }
            resModelArray[i] = model[i];
        }
        if (delIndex == -1) {
            return model;
        }
        for (int j = delIndex; j < resModelArray.length; j++) {
            resModelArray[j] = model[j + 1];
        }
        return resModelArray;
    }
//            int buffer;
//            if (!model[i].equalsIgnoreCase(inputModel)) {
//                resModelArray[i] = model[i];
//            } else if (model[i].equalsIgnoreCase(inputModel)) {
//                resModelArray[i] = model[i + 1];
//                buffer = i + 1;
//                System.out.println(buffer);
//                // i++;
//                for (buffer; buffer < resModelArray.length; buffer++) {
//                    resModelArray[buffer] = model[buffer];
//
//                }
//            }
//        }
//
//        return resModelArray;
//
//    }

    private static String[] addModel(String[] model, Scanner console) {
        System.out.println("Введите новую модель:");
        String inputModel = console.next();
        String[] resModelArray = new String[model.length + 1];
        for (int i = 0; i < model.length; i++) {
            resModelArray[i] = model[i];
        }
        resModelArray[model.length] = inputModel;
        return resModelArray;
    }

    private static void printAllModels(String[] items) {
        for (String model : items) {
            System.out.print(model + " ");
        }
        System.out.println();
    }


    public static void printMenu() {
        System.out.println(" Меню:\n" +
                "1. Посмотреть все модели\n" +
                "2.  Добавить модель\n" +
                "3.  Посмотреть и купить\n" +
                "4.  Отсортировать по алфавиту\n" +
                "5.  Вывести список в обратном порядке (Regex)\n" +
                "6. Узнать, есть ли модель на заданную букву\n" +
                "0. Выход");
    }
}