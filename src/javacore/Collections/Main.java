package javacore.Collections;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        InitialContacts initialContacts = new InitialContacts();
        HashSet<Contact> contacts = initialContacts.initialListOfContacts();
        Map<String, List<Contact>> grouped = contacts.stream()
                .collect(Collectors.groupingBy(Contact::getGroup));// преобразуем set в HashMap<group,List<Contact>>
        Operation operaton = new Operation(contacts, new ArrayList<>(contacts), grouped);

        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            menu();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    operaton.addContact();
                    break;
                case "2":
                    System.out.println("Введите имя контакта для удаления");
                    String name = scanner.nextLine();
                    System.out.println("Введите номер контакта для удаления");
                    String phoneNumber = scanner.nextLine();
                    operaton.deleteContact(name, phoneNumber);
                    break;
                case "3":
                    operaton.showAllContacts();
                    break;
                case "4":
                    System.out.println("Введите 1 для поиска контакта по имени");
                    System.out.println("Введите 2 для поиска контакта по номеру телефона");
                    String input=scanner.nextLine();
                    switch (input){
                        case "1":
                            System.out.println("Введите имя контакта");
                            System.out.println(operaton.findContactByName(scanner.nextLine()));
                            break;
                        case "2":
                            System.out.println("Введите номер контакта");
                            System.out.println(operaton.findContactByPhoneNumber(scanner.nextLine()));
                            break;
                        default:
                            System.out.println("Вы ввели неверную опцию");
                    }
                    break;
                case "5":
                    System.out.println(operaton.getHmapContact());
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Вы ввели неверную опцию, повторите попытку");

            }
        }
        while (!option.equals("0"));
    }

    public static void menu() {
        System.out.println("МЕНЮ");
        System.out.println("1: Добавить контакт");//
        System.out.println("2: Удалить контакт");
        System.out.println("3: Посмотреть все контакты");//
        System.out.println("4: Найти контакт");// по имени и по номеру телефона
        System.out.println("5: Посмотреть контакты по группе");
        System.out.println("0»: Выход");
    }
}