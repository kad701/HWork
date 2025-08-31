package javacore.Collections;

import java.util.HashSet;

public class InitialContacts {

    public HashSet<Contact> initialListOfContacts() {
        HashSet<Contact> contacts = new HashSet<>();
        Contact alex = new Contact("Alex", "2345678", "alex@yahoo", "friend");
        Contact tom = new Contact("Tom", "234458", "tom@yahoo", "family");
        Contact bob = new Contact("bob", "32145678", "bob@yahoo", "work");
        Contact phil = new Contact("phil", "4545678", "phil@yahoo", "friend");
        Contact alicia = new Contact("ann", "567678", "alex@yahoo", "friend");
        Contact ann = new Contact("ann", "78901234", "ann@yahoo", "family");
        Contact mary = new Contact("mary", "4356789", "mary@yahoo", "friend");
        Contact allen = new Contact("allen", "4578932", "allen@yahoo", "work");
        Contact allenCopy = new Contact("allen", "4578932", "allen@yahoo", "work");
        contacts.add(alex);
        contacts.add(tom);
        contacts.add(alicia);
        contacts.add(bob);
        contacts.add(phil);
        contacts.add(ann);
        contacts.add(mary);
        contacts.add(allen);
        contacts.add(allenCopy);
        return contacts;
    }
}

