package javacore.basic;

import java.util.Scanner;

public class Basic {


    private static final int MAX_CONTACTS = 100;
    // Массив для хранения имён контактов
    private static final String[] names = new String[MAX_CONTACTS];
    // Массив для хранения номеров телефонов контактов
    private static final String[] phoneNumbers = new String[MAX_CONTACTS];
    //текущее количесто записей справочнике
    private static int currentAmount = 0;

    public static void main(String[] args) {
        Basic basic = new Basic();
        // добавим несколько пользователей в базу
        names[0] = "holdy";
        phoneNumbers[0] = "234-23-55";
        names[1] = "tonny";
        phoneNumbers[1] = "231-23-15";
        names[2] = "bobby";
        phoneNumbers[2] = "242-42-65";
        names[3] = "annie";
        phoneNumbers[3] = "211-14-15";
        names[4] = "tory";
        phoneNumbers[4] = "266-12-82";
        names[5] = "shaun";
        phoneNumbers[5] = "245-11-29";
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null)
                currentAmount++;
        }

        Scanner scanner = new Scanner(System.in);
        String option;
        //Основное меню
        do {
            System.out.println("МЕНЮ");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Просмотреть контакты");
            System.out.println("3. Найти контакт");
            System.out.println("4. Удалить контакт ");
            System.out.println("5. Выйти");
            option = scanner.nextLine();
            System.out.println("-------------");
            System.out.println("Вы выбрали пункт " + option + " ");
            if (option.equalsIgnoreCase("1")) {
                basic.addContacts(scanner);
                continue;
            }
            if (option.equalsIgnoreCase("2")) {
                basic.showContacts();
                continue;
            }
            if (option.equalsIgnoreCase("3")) {
                basic.findContacts(scanner);
                continue;
            }
            if (option.equalsIgnoreCase("4")) {
                basic.deleteContact(scanner);
                continue;
            } else System.out.println("Выбранный вами пункт меню отсутствует, выберите еще раз");
        }
        while (!option.equals("5"));
        System.out.println("Вы закончили работу");
    }

    // Реализация пунктов меню
    // ("20934".matches("-?[0-9]+"));
    public void addContacts(Scanner scanner) {
        System.out.println("Введите имя нового абонента ");
        String name = scanner.nextLine();
        System.out.println("Введите имя телефон нового абонента ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.matches("-?[0-9]+")) {
            if ((!name.equals("")) && (!phoneNumber.equals(""))) {
                if (currentAmount < MAX_CONTACTS - 1) {
                    currentAmount = currentAmount + 1;
                    names[currentAmount - 1] = name;
                    phoneNumbers[currentAmount - 1] = phoneNumber;
                } else System.out.println("Справочник заполнен, удалите контакт чтобы добавить новый");
            } else System.out.println("Вы не ввели имя или номер абонента, новый абонент не добавлен");
        } else System.out.println("Формат номера не верный,номер должен содержать только цифры, абонент не добавлен");

    } // добавить контакт

    public void showContacts() {

        for (int i = 0; i < currentAmount; i++) {
            System.out.println("Имя --- " + names[i] + "--- Телефон ---" + phoneNumbers[i]);
        }
    } // показать  контакты

    public void findContacts(Scanner scanner) {
        System.out.println("введите опцию");
        System.out.println("1- поиск по имени");
        System.out.println("2- поиск по номеру телефона");

        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("1")) {
            System.out.println("введите имя");
            String name = scanner.nextLine();
            for (int i = 0; i < currentAmount; i++) {
                if (name.equalsIgnoreCase(names[i])) {
                    System.out.println("КОНТАКТ НАЙДЕН");
                    System.out.println("Имя --- " + names[i] + "--- Телефон ---" + phoneNumbers[i]);
                    break;
                }
                if (i == currentAmount - 1)
                    System.out.println("нет контактов ");
            }
        }
        if (option.equalsIgnoreCase("2")) {
            System.out.println("введите номер телефона");
            String phoneNumber = scanner.nextLine();
            for (int i = 0; i < currentAmount; i++) {
                if (phoneNumber.equalsIgnoreCase(phoneNumbers[i])) {
                    System.out.println("КОНТАКТ НАЙДЕН");
                    System.out.println("Имя --- " + names[i] + "--- Телефон ---" + phoneNumbers[i]);
                    break;
                }
                if (i == currentAmount - 1)
                    System.out.println("нет контактов с этим именем");
            }
        }
        System.out.println(option);
        if (!(option.equalsIgnoreCase("1") || option.equalsIgnoreCase("2")))
            System.out.println("Не верная опция");

    }  // поиск контакта по имени или номеру телефона

    public void deleteContact(Scanner scanner) {
        System.out.println("Введите имя контакта для удаления");
        String name = scanner.nextLine();

        for (int i = 0; i < currentAmount; i++) {
            if (name.equalsIgnoreCase(names[i])) {
                names[i] = null;
                phoneNumbers[i] = null;
                currentAmount--;
                System.out.println("Контакт " + name + " найден и удален");
                for (int j = i; j < currentAmount + 1; j++) {
                    String tempName = names[j + 1];
                    String tempPhoneNumber = phoneNumbers[j + 1];
                    if (tempName != null) {
                        names[j] = tempName;
                        phoneNumbers[j] = tempPhoneNumber;
                    } else {
                        names[j] = null;
                        phoneNumbers[j] = null;
                    }
                }
                break;
            } else if (i == currentAmount - 1)
                System.out.println("контакт не найден");
        }
    }// удаление контакта по имени
}
