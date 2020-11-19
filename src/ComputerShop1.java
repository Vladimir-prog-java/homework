import java.util.Arrays;
import java.util.Scanner;

public class ComputerShop1 {
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
                int low = items[0].charAt(0);
                int high = items[items.length - 1].charAt(0);
                quickSort(items, low, high);
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

    public static String[] quickSort(String[] items, int low, int high) {
        //int low;
        //char low = items[0].charAt(0);
        //int high;
        //   char high = items[items.length - 1].charAt(0);
        if (items.length == 0) {
                return items;  //завершить выполнение если длина массива равна 0
        }
        if (low >= high) {
          return items;  //завершить выполнение если уже нечего делить
        }
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        String opora = items[middle];
        System.out.println("Опорный элемент" + opora);
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;

        while (i <= j) {
            while (items[i].charAt(0) < opora.charAt(0)) {
                i++;
            }

            while (items[j].charAt(0) > opora.charAt(0)) {
                j--;
            }

            if (i <= j) {//меняем местами
                String temp = items[i];
                items[i] = items[j];
                items[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(items, low, j);
        if (high > i)
            quickSort(items, i, high);
        return items;
    }
//
// public static void main(String[] args) {
//        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
//        System.out.println("Было");
//        System.out.println(Arrays.toString(x));
//
//        int low = 0;
//        int high = x.length - 1;
//
//        quickSort(x, low, high);
//        System.out.println("Стало");
//        System.out.println(Arrays.toString(x));
//    }


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
        int buffer = -1;
        for (int i = 0; i < model.length; i++) {
            if (model[i].equalsIgnoreCase(inputModel)) {
                buffer = i;
                break;
            }
            resModelArray[i] = model[i];
        }
        for (int i = buffer; i < resModelArray.length; i++) {
            resModelArray[i] = model[i + 1];
        }
        return resModelArray;
    }

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