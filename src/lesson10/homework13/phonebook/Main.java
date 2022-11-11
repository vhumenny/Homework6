package lesson10.homework13.phonebook;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Entry entry1 = new Entry("Vladimir", 123456);
        Entry entry2 = new Entry("Vladimir", 456789);
        Entry entry3 = new Entry("Artem", 434356);
        Entry entry4 = new Entry("Anna", 7645643);

        TelephoneBook telephoneBook = new TelephoneBook(new HashMap<>());

        telephoneBook.add(telephoneBook, entry1.getName(), entry1.getTelephone());
        telephoneBook.add(telephoneBook, entry2.getName(), entry2.getTelephone());
        telephoneBook.add(telephoneBook, entry3.getName(), entry3.getTelephone());
        telephoneBook.add(telephoneBook, entry4.getName(), entry4.getTelephone());

        System.out.println(telephoneBook.getEntries());
        System.out.println(telephoneBook.find(telephoneBook, entry4.getName()));
        System.out.println(telephoneBook.findAll(telephoneBook, entry2.getName()));

    }
}
