package javacore.Collections;

import java.util.Scanner;

public class InputInfo {
    public Contact inputContactInfo(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите имя нового контакта");
        String name=scanner.nextLine();
        System.out.println("Введите номер телефона нового контакта");
        String phonrNumber=scanner.nextLine();
        System.out.println("Введите электронную почту нового контакта");
        String email=scanner.nextLine();
        System.out.println("Введите группу нового контакта");
        String group=scanner.nextLine();
        Contact contact=new Contact(name,phonrNumber,email,group);
        return contact;

    }
}

