package org.example.mobile;

import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact targetContact, Contact newContact) {
        int index = findContact(targetContact);

        if (index >= 0) {
            myContacts.set(index, newContact);
            return true;
        }

        return false;
    }

    public boolean removeContact(Contact targetContact) {
        int index = findContact(targetContact);

        if (index >= 0) {
            myContacts.remove(index);
            return true;
        }

        return false;
    }

    public int findContact(Contact targetContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact currentContact = myContacts.get(i);

            if (currentContact.getName().equals(targetContact.getName())
                    && currentContact.getPhoneNumber().equals(targetContact.getPhoneNumber())) {
                return i;
            }
        }

        return -1;
    }

    public int findContact(String targetContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(targetContact)) {
                return i;
            }
        }

        return -1;
    }

    public Contact queryContact(String contact) {
        int index = findContact(contact);

        if (index >= 0) {
            return myContacts.get(index);
        }

        return null;
    }

    public void printContact() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(i + "." + myContacts.get(i).getName()
                    + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}