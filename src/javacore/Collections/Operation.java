package javacore.Collections;

import java.util.*;

public class Operation {
    private HashSet<Contact> setContact = new HashSet<>();
    private ArrayList<Contact> listContact = new ArrayList<>();
    private Map<String, List<Contact>> hmapContact = new HashMap<>();

    public void addContact() {
        InputInfo inputInfo = new InputInfo();
        Contact contact = inputInfo.inputContactInfo();
        if (setContact.add(contact)) {
            listContact.add(contact);
            String groupKey = contact.getGroup().toLowerCase();
            hmapContact.computeIfAbsent(groupKey, k -> new ArrayList<>()).add(contact);
        } else System.out.println("Такой контакт уже существует");
    }

    public ArrayList<Contact> findContactByName(String name) {
        ArrayList<Contact> foundContact = new ArrayList<>();
        for (Contact element : listContact) {
            if (element.getName().equalsIgnoreCase(name))
                foundContact.add(element);
        }
        return foundContact;
    }

    public Contact findContactByPhoneNumber(String phoneNumber) {
        for (Contact element : listContact) {
            if (element.getPhone().equalsIgnoreCase(phoneNumber))
                return element;
        }
        System.out.println("Введенный вами номер не найден");
        return null;
    }

    public void showAllContacts() {
        Iterator<Contact> iterator = listContact.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    public Map<String, List<Contact>> getHmapContact() {

        return hmapContact;
    }

    public void deleteContact(String name, String phoneNumber) {
        Contact contactForDelete = new Contact(name, phoneNumber, null, null);

        // для Set
        if (!setContact.contains(contactForDelete))
            System.out.println("Нет такого контакта");
        else {
            setContact.remove(contactForDelete);
            // для ArrayList
            Iterator<Contact> iterator = listContact.iterator();
            while (iterator.hasNext()) {
                Contact currentContact = iterator.next();
                if (currentContact.equals(contactForDelete)) {
                    iterator.remove();
                }
            }

            // для Map
            for (Map.Entry<String, List<Contact>> entry : hmapContact.entrySet()) {
                List<Contact> contacts = entry.getValue();
                Iterator<Contact> iteratorMap = contacts.iterator();
                while (iteratorMap.hasNext()) {
                    Contact currentContact = iteratorMap.next();
                    if (currentContact.equals(contactForDelete)) {
                        iteratorMap.remove();
                    }
                }
            }
        }
    }

    public Operation(HashSet<Contact> setContact, ArrayList<Contact> listContact, Map<String, List<Contact>> hmapContact) {
        this.setContact = setContact;
        this.listContact = listContact;
        this.hmapContact = hmapContact;
    }


}
