package lesson10.homework13.phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class TelephoneBook {

    private HashMap<Integer, String> entries;

    public void add(TelephoneBook telephoneBook, String name, Integer telephone) {
        telephoneBook.getEntries().put(telephone, name);
    }

    public String find(TelephoneBook telephoneBook, String name) {
        String result = null;
        for (Map.Entry<Integer, String> entry : telephoneBook.getEntries().entrySet()) {
            if (entry.getValue().equals(name)) {
                result = "Telephone: " + entry.getKey() + ": Name - " + entry.getValue();
                break;
            }
        }
        return result;
    }

    public String findAll(TelephoneBook telephoneBook, String name) {
        String result = null;
        for (Map.Entry<Integer, String> entry : telephoneBook.getEntries().entrySet()) {
            if (entry.getValue().equals(name) && result == null) {
                result = "Telephone: " + entry.getKey() + ": Name - " + entry.getValue()+"\n";
                continue;
            }
            if (entry.getValue().equals(name)) {
                result += "Telephone: " + entry.getKey() + ": Name - " + entry.getValue();
            }
        }
        return result;
    }

    public TelephoneBook(HashMap<Integer, String> entries) {
        this.entries = entries;
    }

    public HashMap<Integer, String> getEntries() {
        return entries;
    }

    public void setEntries(HashMap<Integer, String> entries) {
        this.entries = entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneBook that = (TelephoneBook) o;
        return Objects.equals(entries, that.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entries);
    }
}
